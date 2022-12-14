package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editRaisePage {

    WebDriver driver;

    @FindBy(xpath = "//tbody[1]/tr[1]/td[2]/div[1]/a[1]")
    private WebElement edit_btn;

    public editRaisePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_edit() {
        try {
            if (edit_btn.isDisplayed()) {
                edit_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        try {
            WebElement input = driver.findElement(By.tagName("input"));
            if (input.isDisplayed()) {
                input.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendkeytxt() {
        try {
            WebElement input = driver.findElement(By.tagName("input"));
            if (input.isDisplayed()) {
                input.sendKeys("A");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
