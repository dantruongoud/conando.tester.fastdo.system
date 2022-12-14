package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editCriteriaPage {

    WebDriver driver;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/a[1]")
    private WebElement edit_btn;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement nameCriteria;

    public editCriteriaPage(WebDriver driver) {
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
            if (nameCriteria.isDisplayed()) {
                nameCriteria.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
