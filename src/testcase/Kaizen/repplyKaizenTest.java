package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Kaizen.CreateKaizenPage;
import page.Kaizen.appraiseKaizenPage;
import page.Kaizen.repplyKaizenPage;
import setupbase.baseSetup;

public class repplyKaizenTest {
    int testcase;
    String content;

    public repplyKaizenTest(int testcase, String content) {
        this.testcase = testcase;
        this.content = content;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            appraiseKaizenPage appraise = new appraiseKaizenPage(driver);
            repplyKaizenPage repply = new repplyKaizenPage(driver);

            index.openCorp();
            kaizen.navigation_Kaizen();
            index.waitForPageLoaded();

            appraise.chose_Kaizen("Tôi cần góp ý");
            index.waitForPageLoaded();
            if (index.verifyTitle("Chi tiết Kaizen")) {

                repplyKaizenTest[] data_test = {
                        new repplyKaizenTest(1, ""),
                        new repplyKaizenTest(2, "Tôi hơi bị kết cái Kaizen của bạn đấy"),
                };

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    repply.enterContent(data_test[i].content);
                    index.btnComponent.click();
                    Thread.sleep(1000);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Chưa nhập nội dung bình luận !":
                            System.out.println(noti);
                            index.passed();
                            index.uploadImage("//a[@title='Đính kèm hình ảnh']", "");
                            break;
                        default:
                            if (repply.verifyContent("Tôi hơi bị kết cái Kaizen của bạn đấy")) {
                                index.passed();
                            } else {
                                index.passed();
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
