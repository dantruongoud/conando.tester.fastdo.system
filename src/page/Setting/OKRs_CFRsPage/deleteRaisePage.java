package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteRaisePage {

    WebDriver driver;

    @FindBy(xpath = "//tbody[1]/tr[1]/td[2]/div[1]/a[2]")
    private WebElement delete_btn;

    public deleteRaisePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_del() {
        try {
            if (delete_btn.isDisplayed()) {
                delete_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
