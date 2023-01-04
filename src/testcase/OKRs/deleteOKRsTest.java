package testcase.OKRs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page.index;
import setupbase.baseSetup;

public class deleteOKRsTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            page.OKRs.CreateOKRsPage create = new page.OKRs.CreateOKRsPage(driver);
            page.OKRs.editOKRsPage edit = new page.OKRs.editOKRsPage(driver);
            page.OKRs.deleteOKRsPage delete = new page.OKRs.deleteOKRsPage(driver);

            index.openCorp();
            create.navigation_OKRsPageEdit();

            edit.chose_OKRsedit("OKRs QUY I");
            index.waitForPageLoaded();

            delete.delete_btn.click();
            Thread.sleep(1000);

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            System.out.println("Xoá thành công");
            index.passed();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
