package testcase.CFRs.Recognition_Star;

import org.openqa.selenium.WebDriver;

import page.index;
import page.CFRs.Checkin.CreateDraftCheckinPage;
import page.CFRs.Recognition_Star.recognitonPage;
import setupbase.baseSetup;

public class recognitionTest {
    int testcase;
    String content;

    public recognitionTest(int testcase, String content) {
        this.testcase = testcase;
        this.content = content;
    }

    public static void main(String[] args) {
        try {

            recognitionTest[] data_test = {
                    new recognitionTest(1, "content"),
                    new recognitionTest(2, "content"),
                    new recognitionTest(3, ""),
                    new recognitionTest(4, ""),
                    new recognitionTest(5, "content")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);
            recognitonPage use = new recognitonPage(driver);

            index.openCorp();
            create.navigation_CFRs();
            Thread.sleep(1000);
            use.navigation_recognition();
            index.waitForPageLoaded();

            if (index.verifyTitle("CFRs - Ghi nhận & Tặng sao")) {

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    use.recognition(data_test[i].content);
                    Thread.sleep(1000);
                    index.btnComponent.click();
                    Thread.sleep(1000);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa chọn người nhận !":
                            System.out.println(noti);
                            index.passed();
                            create.research("NGUYEN DAN TRUONG");
                            Thread.sleep(1000);
                            create.click_Usercheckin();
                            Thread.sleep(1000);
                            use.clear();
                            break;
                        case "Bạn không thể ghi nhận - tặng sao cho chính mình !":
                            create.clearSearch();
                            System.out.println(noti);
                            index.passed();
                            create.research("tan");
                            Thread.sleep(1000);
                            create.click_Usercheckin();
                            Thread.sleep(1000);
                            break;
                        case "Bạn chưa chọn tiêu chí ghi nhận !":
                            System.out.println(noti);
                            index.passed();
                            use.select();
                            Thread.sleep(1200);
                            use.clear();
                            break;
                        case "Bạn chưa nhập nội dung !":
                            System.out.println(noti);
                            index.passed();
                            break;
                        default:
                            // noti = index.messgaeError_tagline();
                            if (noti.equals("Bạn đã Gửi ghi nhận cho tan tan thành công!")) {
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
