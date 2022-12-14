package testcase.Setting.Educate;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Educate.CreateCategoryPage;
import setupbase.baseSetup;

public class CreateCategoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            CreateCategoryPage create = new CreateCategoryPage(driver);

            using.openCorp();
            using.navigation();
            Thread.sleep(1000);
            create.naviga.click();
            using.waitForPageLoaded();

            if (using.verifyTitle("Quản lý danh mục đào tạo")) {
                create.click_create();
                Thread.sleep(1000);
                System.out.println("========================");
                System.out.println("Testcase: 1");
                create.click_save();
                String noti = using.messgaeError_tagline();
                if (noti != null) {
                    System.out.println(noti);
                    using.passed();
                    create.enterName("AAAA");
                    Thread.sleep(1000);
                    using.uploadImage("//div[@class='field']//div[@class='control is-expanded']", "xpath");
                    Thread.sleep(1000);
                    System.out.println("========================");
                    System.out.println("Testcase: 2");
                    create.click_save();
                    Thread.sleep(1000);
                    if (create.verifyText()) {
                        System.out.println("Tạo mới thành công");
                        using.passed();
                    } else {
                        using.failed();
                    }
                } else {
                    using.failed();
                }
            } else {
                using.error_titlePage();
            }
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }
}
