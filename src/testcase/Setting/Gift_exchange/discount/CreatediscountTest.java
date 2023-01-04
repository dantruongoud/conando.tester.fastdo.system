package testcase.Setting.Gift_exchange.discount;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Gift_exchange.discount.CreateDiscountPage;
import page.Setting.Gift_exchange.store.CreateProductPage;
import setupbase.baseSetup;

public class CreatediscountTest {
    int testcase;
    String name;

    public CreatediscountTest(int testcase, String name) {
        this.testcase = testcase;
        this.name = name;
    }

    public static void main(String[] args) {
        try {

            CreatediscountTest[] data = {
                    new CreatediscountTest(1, "name discount"),
                    new CreatediscountTest(2, ""),
                    new CreatediscountTest(3, "name discount"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            CreateProductPage create = new CreateProductPage(driver);
            CreateDiscountPage discount = new CreateDiscountPage(driver);

            using.openCorp();
            Thread.sleep(1000);
            using.navigation();
            Thread.sleep(1000);
            create.navigation_exchange();
            using.waitForPageLoaded();

            discount.naviga.click();
            using.waitForPageLoaded();

            discount.click_create();
            Thread.sleep(1000);

            System.out.println("=====================");
            System.out.println("TestCase: " + data[0].testcase);
            discount.enterName(data[0].name);

            String noti = using.messgaeError_tagline();
            if (noti.equals("Nhập các trường bắt buộc (*)")) {
                System.out.println(noti);
                using.passed();
                using.uploadImage("//div[@class='field']//div[@class='control is-expanded']", "xpath");

                for (int i = 1; i < data.length; i++) {
                    discount.name_input.clear();
                    System.out.println("=====================");

                    System.out.println("TestCase: " + data[i].testcase);
                    discount.enterName(data[i].name);

                    noti = using.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập các trường bắt buộc (*)":
                            System.out.println(noti);
                            using.passed();
                            break;

                        default:
                            if (noti.equals("Đã cập nhật banner ưu đãi thành công!")) {
                                using.passed();
                            } else {
                                System.out.println(noti);
                                using.failed();
                            }
                            break;
                    }
                }
            } else {
                using.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
