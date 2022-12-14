package page.Setting.Gift_exchange.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editProductPage {

    WebDriver driver;

    @FindBy(linkText = "name")
    private WebElement nameProduct;

    public editProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyProduct() {
        try {
            return nameProduct.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clickNameProduct() {
        try {
            if (nameProduct.isDisplayed()) {
                nameProduct.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
