package testcase.Setting.Kaizen;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Kaizen.CreateTopicPage;
import page.Setting.Kaizen.deleteTopicPage;
import setupbase.baseSetup;

public class deleteTopicTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            using.login();
            using.navigation();
            CreateTopicPage create = new CreateTopicPage(driver);
            create.naviga_kaizen();
            using.waitForPageLoaded();
            deleteTopicPage del = new deleteTopicPage(driver);
            del.checklist();
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            System.out.println("============================");
            alert.accept();
            System.out.println("Xóa thành công");
            using.passed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
