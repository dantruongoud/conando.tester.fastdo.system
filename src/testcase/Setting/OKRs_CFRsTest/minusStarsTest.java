package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.OKRs_CFRsPage.SupplyStarPage;
import page.Setting.OKRs_CFRsPage.cyclePage;
import page.Setting.OKRs_CFRsPage.minusSatrsPage;
import setupbase.baseSetup;

public class minusStarsTest {
    int testcase;
    String number;

    public minusStarsTest(int testcase, String number) {
        this.testcase = testcase;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            SupplyStarPage supply = new SupplyStarPage(driver);
            minusSatrsPage minus = new minusSatrsPage(driver);
            cyclePage cycle = new cyclePage(driver);
            using.openCorp();
            using.navigation();
            Thread.sleep(500);

            cycle.navigation_OKRs_CFRs();
            minus.naviga_minusStar();
            using.waitForPageLoaded();

            minus.click_create();

            minusStarsTest[] data_test = {
                    new minusStarsTest(1, ""),
                    new minusStarsTest(2, ""),
                    new minusStarsTest(3, "1"),
            };

            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                supply.supply(data_test[i].number);
                Thread.sleep(1000);

                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn chưa chọn nhân viên cần trừ sao !":
                        System.out.println(noti);
                        using.passed();
                        supply.click_choseUser();
                        break;
                    case "Bạn chưa nhập số sao muốn trừ !":
                        System.out.println(noti);
                        using.passed();
                        break;
                    default:
                        supply.click_confirm();
                        noti = using.messgaeError_tagline();
                        if (noti.equals("Bạn đã trừ 1 sao cho 1 nhân sự.")) {
                            System.out.println(noti);
                            using.passed();
                        } else {
                            using.passed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
