package page.Setting.StructurePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Nhân sự')]")
    private WebElement naviga;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement create_btn;

    @FindBy(css = "input[placeholder='Email sẽ dùng để đăng nhập...']")
    private WebElement username_input;

    @FindBy(xpath = "//li[contains(@class,'column is-full')]//input[contains(@type,'text')]")
    private WebElement password_input;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/form[1]/ul[1]/li[3]/div[1]/div[1]/input[1]")
    private WebElement lastname_input;

    @FindBy(xpath = "//body[1]/main[1]/section[1]/section[1]/div[2]/div[1]/form[1]/ul[1]/li[4]/div[1]/div[1]/input[1]")
    private WebElement firstname_input;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement save_btn;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_user() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
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

    public void createUser(String email, String lastname, String firstname, String password) {
        username_input.sendKeys(email);
        lastname_input.sendKeys(lastname);
        firstname_input.sendKeys(firstname);
        password_input.sendKeys(password);
        save_btn.click();
    }

    public void cleartxt() {
        username_input.clear();
        lastname_input.clear();
        firstname_input.clear();
        password_input.clear();
    }

    public void print() {
        System.out.println("PASSED");
        System.out.println("=========================");
        cleartxt();
    }
}
