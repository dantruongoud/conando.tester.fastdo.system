package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.OKRs_CFRsPage.SupplyStarPage;
import page.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class SupplyStarTest {
    int testcase;
    String number;

    public SupplyStarTest(int testcase, String number) {
        this.testcase = testcase;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            SupplyStarTest[] data_test = {
                    new SupplyStarTest(1, ""),
                    new SupplyStarTest(2, ""),
                    new SupplyStarTest(3, "1"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            cyclePage cycle = new cyclePage(driver);
            SupplyStarPage supply = new SupplyStarPage(driver);

            using.openCorp();
            using.navigation();
            Thread.sleep(500);

            cycle.navigation_OKRs_CFRs();
            supply.naviga_supplyStar();
            using.waitForPageLoaded();

            supply.click_create();

            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);

                supply.supply(data_test[i].number);
                Thread.sleep(1000);

                String noti = using.messgaeError_tagline();

                switch (noti) {
                    case "Bạn chưa chọn nhân viên cần cấp sao !":
                        System.out.println(noti);
                        using.passed();
                        supply.click_choseUser();
                        break;
                    case "Bạn chưa nhập số sao muốn cấp !":
                        System.out.println(noti);
                        using.passed();
                        break;
                    default:
                        supply.click_confirm();
                        noti = using.messgaeError_tagline();
                        if (noti.equals("Bạn đã cấp 1 sao cho 1 nhân sự.")) {
                            System.out.println(noti);
                            using.passed();
                        } else {
                            using.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
