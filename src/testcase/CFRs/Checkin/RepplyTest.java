package testcase.CFRs.Checkin;

import org.openqa.selenium.WebDriver;

import page.index;
import page.CFRs.Checkin.CreateDraftCheckinPage;
import page.CFRs.Checkin.RepplyPage;
import setupbase.baseSetup;

public class RepplyTest {
    int testcase;
    String repply;

    public RepplyTest(int testcase, String repply) {
        this.testcase = testcase;
        this.repply = repply;
    }

    public static void main(String[] args) {
        try {

            RepplyTest[] data_test = {
                    new RepplyTest(1, ""),
                    new RepplyTest(2, "Cảm ơn Ngài!!!")
            };
            
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);
            RepplyPage Repply = new RepplyPage(driver);

            index.openCorp();
            create.navigation_CFRs();
            Thread.sleep(1000);
            create.navigation_checkin();
            index.waitForPageLoaded();

            create.chose_OKRs("Đã check-in");
            Thread.sleep(1000);
            Repply.navigation_repply();
            index.waitForPageLoaded();

            if (index.verifyTitle("CFRs - Phản hồi Check-in")) {

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    Repply.enterRepply(data_test[i].repply);
                    index.btnComponent.click();

                    Thread.sleep(1200);
                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập nội dung phản hồi !":
                            System.out.println(noti);
                            index.passed();
                            Repply.uploadImage();
                            break;
                        default:
                            if (Repply.verifyCmt("Cảm ơn Ngài!!!")) {
                                System.out.println("Phản hồi thành công");
                                index.passed();
                            } else {
                                index.failed();
                            }
                            break;
                    }
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
