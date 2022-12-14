package testcase.Setting.Gift_exchange.discount;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Gift_exchange.discount.CreateDiscountPage;
import page.Setting.Gift_exchange.store.CreateProductPage;
import setupbase.baseSetup;

public class CreatediscountTest {
    public static void main(String[] args) {
        try {
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

            discount.click_save();
            System.out.println("Testcase: 1");
            System.out.println("=====================");
            String noti = using.messgaeError_tagline();
            if (noti != null) {
                System.out.println(noti);
                discount.enterName("name");
                using.passed();
                discount.click_save();
                System.out.println("Testcase: 2");
                System.out.println("=====================");
                noti = using.messgaeError_tagline();
                if (noti != null) {
                    System.out.println(noti);
                    using.passed();
                    using.uploadImage("//div[@class='field']//div[@class='control is-expanded']", "xpath");
                    discount.click_save();
                    System.out.println("Testcase: 3");
                    System.out.println("=====================");
                    if (discount.verifyText()) {
                        System.out.println("Tạo mới thành công");
                        using.passed();
                    } else {
                        using.failed();
                    }
                } else {
                    using.failed();
                }
            } else {
                using.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
