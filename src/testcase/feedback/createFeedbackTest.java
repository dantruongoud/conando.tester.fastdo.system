package testcase.feedback;

import org.openqa.selenium.WebDriver;

import page.index;
import page.feedback.createFeedbackPage;
import setupbase.baseSetup;

public class createFeedbackTest {
    int testcase;
    String title, content;

    public createFeedbackTest(int testcase, String title, String content) {
        this.testcase = testcase;
        this.title = title;
        this.content = content;
    }

    public static void main(String[] args) {
        try {
            createFeedbackTest[] data_test = {
                    new createFeedbackTest(1, "", "content"),
                    new createFeedbackTest(2, "Tôi muốn góp ý", ""),
                    new createFeedbackTest(3, "Tôi muốn góp ý", "Tôi góp ý là"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createFeedbackPage create = new createFeedbackPage(driver);

            index.openCorp();
            create.navigation_feedback();
            index.waitForPageLoaded();

            if (index.verifyTitle("Góp ý hệ thống")) {

                index.btnComponent.click();

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    create.createFeedback(data_test[i].title, data_test[i].content);
                    index.btnComponent.click();

                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Nhập đủ tiêu đề và nội dung !":
                            System.out.println(noti);
                            create.print();
                            break;
                        default:
                            noti = index.messgaeError_tagline();
                            if (noti.equals("Đã gửi góp ý thành công")) {
                                System.out.println(noti);
                                index.passed();
                            } else {
                                System.out.println(noti);
                                index.failed();
                            }
                            break;
                    }
                    Thread.sleep(1000);
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
