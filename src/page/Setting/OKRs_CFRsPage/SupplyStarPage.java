package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SupplyStarPage {
    private WebDriver driver;

    private By supplyStar = By.cssSelector("a[href='/config/okrs/stars/plus']");

    private By create_btn = By.cssSelector("a[class='button is-link']");

    private By save_btn = By.xpath("//span[contains(text(),'Cập nhật')]");

    private By confirm_btn = By.xpath("//span[contains(text(),'Xác nhận')]");

    private By choseUser_btn = By
            .xpath("/html/body/main/section/section[1]/div[2]/div/div[2]/table/tbody/tr[1]/td[1]/label/input");

    private By starNumber_input = By.xpath("//input[@type='number']");

    public SupplyStarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void naviga_supplyStar() {
        try {
            WebElement navigation = driver.findElement(supplyStar);
            if (navigation.isDisplayed()) {
                navigation.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_create() {
        try {
            WebElement createBtn = driver.findElement(create_btn);
            if (createBtn.isDisplayed()) {
                createBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_save() {
        try {
            WebElement saveBtn = driver.findElement(save_btn);
            if (saveBtn.isDisplayed()) {
                saveBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_confirm() {
        try {
            WebElement confirmBtn = driver.findElement(confirm_btn);
            if (confirmBtn.isDisplayed()) {
                confirmBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterStarnumer(String number) {
        try {
            WebElement starNumbertxt = driver.findElement(starNumber_input);
            if (starNumbertxt.isDisplayed()) {
                starNumbertxt.sendKeys(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_choseUser() {
        try {
            WebElement choseUserBtn = driver.findElement(choseUser_btn);
            if (choseUserBtn.isDisplayed()) {
                choseUserBtn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void supply(String number) {
        enterStarnumer(number);
        click_save();
    }

}
