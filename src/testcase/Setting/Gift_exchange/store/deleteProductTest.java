package testcase.Setting.Gift_exchange.store;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Gift_exchange.store.CreateProductPage;
import page.Setting.Gift_exchange.store.deleteProductPage;
import setupbase.baseSetup;

public class deleteProductTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            CreateProductPage create = new CreateProductPage(driver);
            deleteProductPage del = new deleteProductPage(driver);

            using.openCorp();
            Thread.sleep(1000);
            using.navigation();
            Thread.sleep(1000);
            create.navigation_exchange();
            using.waitForPageLoaded();

            del.click_delete();
            Thread.sleep(1000);

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            System.out.println("=======================");
            alert.accept();
            System.out.println("Xóa thành công");
            using.passed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
