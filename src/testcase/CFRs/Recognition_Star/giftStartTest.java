package testcase.CFRs.Recognition_Star;

import org.openqa.selenium.WebDriver;

import page.index;
import page.CFRs.Checkin.CreateDraftCheckinPage;
import page.CFRs.Recognition_Star.giftStartPage;
import page.CFRs.Recognition_Star.recognitonPage;
import setupbase.baseSetup;

public class giftStartTest {
    int testcase;
    String number;

    public giftStartTest(int testcase, String number) {
        this.testcase = testcase;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            giftStartTest[] data_test = {
                    new giftStartTest(1, "2"),
                    new giftStartTest(2, "2"),
                    new giftStartTest(3, "0"),
                    new giftStartTest(4, "1"),
                    new giftStartTest(5, "1"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);
            recognitonPage use = new recognitonPage(driver);
            giftStartPage Star = new giftStartPage(driver);

            index.openCorp();
            create.navigation_CFRs();
            Thread.sleep(1000);
            use.navigation_recognition();
            index.waitForPageLoaded();

            if (index.verifyTitle("CFRs - Ghi nhận & Tặng sao")) {

                Star.select();

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    Star.clearDataTest();

                    Star.Stargift(data_test[i].number);
                    Thread.sleep(1000);
                    index.btnComponent.click();

                    Thread.sleep(500);

                    Boolean passed = false;
                    String noti = index.messgaeError_tagline();
                    for (int j = 0; j < Star.tagline.length; j++) {
                        if (noti.equals(Star.tagline[j])) {
                            passed = true;
                            index.passed();
                            if (j == 0)
                                create.research("TRUONG");
                            if (j == 1)
                                create.research("tan tan");
                            if (j == 3)
                                use.enterContent("Bạn làm rất tốt");
                            break;
                        } else if (noti.contains("Bạn đã Tặng 1 sao cho")) {
                            passed = true;
                            index.passed();
                            break;
                        }
                    }
                    if (!passed)
                        index.failed();
                    // switch (noti) {
                    // case "Bạn chưa chọn người nhận !":
                    // System.out.println(noti);
                    // Star.print();
                    // create.research("NGUYEN DAN TRUONG");
                    // Thread.sleep(1000);
                    // break;
                    // case "Bạn không thể ghi nhận - tặng sao cho chính mình !":
                    // create.clearSearch();
                    // System.out.println(noti);
                    // Star.print();
                    // create.research("tan");
                    // Thread.sleep(1000);
                    // create.click_Usercheckin();
                    // Thread.sleep(1000);
                    // break;
                    // case "Bạn chưa chọn số sao muốn tặng !":
                    // System.out.println(noti);
                    // Star.print();
                    // break;
                    // case "Bạn chưa nhập nội dung !":
                    // System.out.println(noti);
                    // Star.print();
                    // use.enterContent("content");
                    // break;
                    // default:
                    // if (noti.contains("Bạn đã Tặng 1 sao cho")) {
                    // System.out.println(noti);
                    // index.passed();
                    // } else {
                    // index.failed();
                    // }
                    // break;
                    // }
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
