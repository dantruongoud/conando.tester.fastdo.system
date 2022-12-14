package page.Setting.Gift_exchange.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteProductPage {

    WebDriver driver;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/a[2]")
    private WebElement delete_btn;

    public deleteProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_delete() {
        try {
            if (delete_btn.isDisplayed()) {
                delete_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
