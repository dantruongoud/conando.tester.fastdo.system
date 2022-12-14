package testcase.Setting.Educate;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Educate.CreateCategoryPage;
import page.Setting.Educate.CreateCertificationPage;
import setupbase.baseSetup;

public class CreateCertificationTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            CreateCategoryPage create = new CreateCategoryPage(driver);
            CreateCertificationPage create_certification = new CreateCertificationPage(driver);
            using.openCorp();
            using.navigation();
            create.naviga.click();
            using.waitForPageLoaded();
            create_certification.navigation_certification();
            Thread.sleep(1000);
            using.btnComponent.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
