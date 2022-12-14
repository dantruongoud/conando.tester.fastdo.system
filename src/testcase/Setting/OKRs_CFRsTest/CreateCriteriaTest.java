package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.OKRs_CFRsPage.CreateCriteriaPage;
import page.Setting.OKRs_CFRsPage.cyclePage;
import setupbase.baseSetup;

public class CreateCriteriaTest {
    int testcase;
    String name;

    public CreateCriteriaTest(int testcase, String name) {
        this.testcase = testcase;
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            cyclePage cycle = new cyclePage(driver);
            CreateCriteriaPage criteria = new CreateCriteriaPage(driver);

            using.openCorp();
            using.navigation();
            Thread.sleep(1000);
            cycle.navigation_OKRs_CFRs();
            criteria.navigation_criteria();
            using.waitForPageLoaded();

            criteria.click_create();

            CreateCriteriaTest[] data_test = {
                    new CreateCriteriaTest(1, ""),
                    new CreateCriteriaTest(2, "A")
            };

            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                criteria.create_criteria(data_test[i].name);
                Thread.sleep(1000);

                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn cần nhập tên tiêu chí !":
                        System.out.println(noti);
                        using.passed();
                        break;
                    default:
                        if (criteria.verifyText("A")) {
                            System.out.println("Tạo mới thành công");
                            using.passed();
                        } else {
                            using.failed();
                        }
                        break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
