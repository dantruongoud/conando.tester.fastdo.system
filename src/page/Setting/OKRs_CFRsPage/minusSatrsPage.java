package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class minusSatrsPage {

    WebDriver driver;

    @FindBy(css = "a[href='/config/okrs/stars/minus']")
    private WebElement minusStar;

    @FindBy(xpath = "//a[@class='button is-danger']")
    private WebElement create_btn;

    public minusSatrsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void naviga_minusStar() {
        try {
            if (minusStar.isDisplayed()) {
                minusStar.click();
            }
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
