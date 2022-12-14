package page.Setting.StructurePage;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Từ khóa: email, tên...']")
    private WebElement search_input;

    @FindBy(xpath = "//span[contains(text(),'Tìm kiếm')]")
    private WebElement search_btn;

    @FindBy(className = "user_item")
    public WebElement chose_user;

    @FindBy(xpath = "//ul[@class='columns is-multiline']/li[2]//input[@class='input']")
    private WebElement lastname_input;

    @FindBy(xpath = "//ul[@class='columns is-multiline']/li[3]//input[@class='input']")
    private WebElement firstname_input;

    @FindBy(css = "a[class='button is-link']")
    private WebElement save_btn;

    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Hàm check input disable
    public boolean isElementEnable(WebDriver driver, String locator) {
        try {
            WebElement usernametxt;
            usernametxt = driver.findElement(By.xpath(locator));
            return usernametxt.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Hàm check input username
    public void check_usernameDisable() {
        String username_input = "//input[@type='email']";
        if (isElementEnable(driver, username_input)) {
            System.out.println("FAILED: INPUT IS ENABLE...");
        } else {
            System.out.println("PASSED: INPUT IS DISABLE");
        }
    }

    public void enterSearch(String email) {
        try {
            search_input.sendKeys(email);
            Thread.sleep(1000);
            search_btn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        try {
            lastname_input.clear();
            firstname_input.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(String lastname, String firstname) {
        try {
            lastname_input.sendKeys(lastname);
            firstname_input.sendKeys(firstname);
            Thread.sleep(1000);
            save_btn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifyTitle() {
        String a = "Thông tin tài khoản";
        return getTitle().equals(a);
    }
}
