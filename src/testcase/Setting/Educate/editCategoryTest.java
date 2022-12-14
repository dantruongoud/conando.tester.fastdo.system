package testcase.Setting.Educate;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Educate.CreateCategoryPage;
import page.Setting.Educate.edit_del_CategoryPage;
import setupbase.baseSetup;

public class editCategoryTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            CreateCategoryPage create = new CreateCategoryPage(driver);
            edit_del_CategoryPage edit = new edit_del_CategoryPage(driver);

            using.openCorp();
            using.navigation();
            create.naviga.click();
            using.waitForPageLoaded();
            edit.enterSearch("AAAA");
            edit.click_search();
            using.waitForPageLoaded();
            edit.click_edit();
            Thread.sleep(1000);
            edit.cleartxt();
            create.click_save();
            System.out.println("=====================");
            System.out.println("Testcase: 1");
            String noti = using.messgaeError_tagline();
            if (noti != null) {
                System.out.println(noti);
                using.passed();
                create.enterName("A");
                create.click_save();
                System.out.println("=====================");
                System.out.println("Testcase: 2");
                Thread.sleep(2000);
                if (edit.verifyText("A")) {
                    System.out.println("Cập nhật thành công");
                    using.passed();
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
