package page.Setting.Gift_exchange.discount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDiscountPage {
    WebDriver driver;

    @FindBy(css = "a[href='/config/gift/banner']")
    public WebElement naviga;

    @FindBy(xpath = "//a[@class='button is-link']")
    private WebElement create_btn;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    public WebElement name_input;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    public CreateDiscountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        try {
            name_input.sendKeys(name);
            Thread.sleep(500);
            save_btn.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_create() {
        try {
            if (create_btn.isDisplayed()) {
                create_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
