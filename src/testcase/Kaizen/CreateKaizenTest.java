package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Kaizen.CreateKaizenPage;
import setupbase.baseSetup;

public class CreateKaizenTest {
    int testcase;
    String title, content;

    public CreateKaizenTest(int testcase, String title, String content) {
        this.testcase = testcase;
        this.title = title;
        this.content = content;
    }

    public static void main(String[] args) {
        try {
            CreateKaizenTest[] data_test = {
                    new CreateKaizenTest(1, "", "Content"),
                    new CreateKaizenTest(2, "Tiêu đề", ""),
                    new CreateKaizenTest(3, "Tôi cần góp ý", "Cái này cần thay đổi như vậy nè")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            index.openCorp();

            kaizen.navigation_Kaizen();
            index.waitForPageLoaded();

            if (index.verifyTitle("Diễn đàn Kaizen")) {
                index.btnComponent.click();
                Thread.sleep(2000);
                kaizen.chose_catagory("Gia tăng năng suất");
                kaizen.chose_subCategory("Cải thiện cách đánh giá nhân sự");

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    
                    System.out.println("Testcase: " + data_test[i].testcase);
                    kaizen.createKaizen(data_test[i].title, data_test[i].content);
                    index.btnComponent.click();
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập đủ tiêu đề và nội dung !":
                            System.out.println(noti);
                            kaizen.print();
                            break;
                        default:
                            noti = index.messgaeError_tagline();
                            if (noti.equals("Đã gửi góp ý Kaizen thành công!")) {
                                System.out.println(noti);
                                index.passed();
                            } else {
                                index.failed();
                            }
                            break;
                    }

                    Thread.sleep(1200);
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
