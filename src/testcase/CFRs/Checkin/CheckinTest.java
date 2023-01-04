package testcase.CFRs.Checkin;

import org.openqa.selenium.WebDriver;

import page.index;
import page.CFRs.Checkin.CheckinPage;
import page.CFRs.Checkin.CreateDraftCheckinPage;
import setupbase.baseSetup;

public class CheckinTest {

    int testcase;
    String repply, day;

    public CheckinTest(int testcase, String repply,
            String day) {
        this.testcase = testcase;
        this.repply = repply;
        this.day = day;
    }

    public static void main(String[] args) {
        try {
            CheckinTest[] data_test = {
                    new CheckinTest(1, "", "20/9/2022"),
                    new CheckinTest(2, "Làm tốt lắm em ơi", ""),
                    new CheckinTest(3, "Làm tốt lắm em ơi", "20/09/2022")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);

            index.openCorp();
            create.navigation_CFRs();
            Thread.sleep(1000);
            create.navigation_checkin();
            index.waitForPageLoaded();

            if (index.verifyTitle("CFRs - Check-in")) {
                create.chose_OKRs("Đã xác nhận");
                index.waitForPageLoaded();

                create.click_checkin11();
                Thread.sleep(1000);
                index.btnComponent.click();
                Thread.sleep(1000);

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    CheckinPage checkin = new CheckinPage(driver);
                    checkin.textRepply(data_test[i].repply, data_test[i].day);
                    Thread.sleep(1500);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập phản hồi cho kết quả then chốt !":
                            System.out.println(noti);
                            checkin.print();
                            break;
                        case "Bạn chưa chọn lần check-in tiếp theo hoặc chọn Hoàn thành OKRs!":
                            System.out.println(noti);
                            Thread.sleep(1000);
                            checkin.print();
                            break;
                        default:
                            if (checkin.verifyButton()) {
                                System.out.println("Checkin success");
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
