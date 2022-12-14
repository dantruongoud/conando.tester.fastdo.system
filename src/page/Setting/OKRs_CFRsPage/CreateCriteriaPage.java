package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCriteriaPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement nameCriteria;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement starNumber;

    @FindBy(xpath = "//a[contains(text(),'Tiêu chí đánh giá')]")
    private WebElement naviga;

    @FindBy(css = "a[class='button']")
    private WebElement create_btn;

    public CreateCriteriaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void navigation_criteria() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterStarNumber(String number) {
        try {
            if (starNumber.isDisplayed()) {
                starNumber.sendKeys(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyText(String condition) {
        WebElement td = driver.findElement(By.cssSelector(".has-text-weight-semibold"));
        String a = td.getText().strip();
        return a.equals(condition);
    }

    public void create_criteria(String name) {
        nameCriteria.sendKeys(name);
        save_btn.click();
    }

    public void click_save() {
        try {
            save_btn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterNameCriteria(String name) {
        try {
            nameCriteria.sendKeys(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
