package page.Educate.qiz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createQizPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @FindBy(xpath = "//span[contains(text(),'Thêm bài trắc nghiệm')]")
    private WebElement qiz_btn;

    @FindBy(css = "input[placeholder='Nhập tiêu đề bài trắc nghiệm...']")
    private WebElement titleQiz_input;

    @FindBy(xpath = "/html/body/main/section/section/div/ul[2]/li[3]/div/div/input")
    private WebElement time_input;

    @FindBy(tagName = "textarea")
    private WebElement contentQuestion_input;

    @FindBy(css = "input[class='input']")
    private WebElement point_input;

    @FindBy(xpath = "/html/body/main/section/section/div/ul[2]/li[4]/ul/li[3]/ul/li[1]/div/div[2]/input")
    private WebElement result_input;

    @FindBy(css = "input[type='checkbox']")
    public WebElement checkbox_check;

    public createQizPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_qiz() {
        try {
            if (qiz_btn.isDisplayed()) {
                qiz_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create_qiz(String title, String time, String point, String content, String result) {
        titleQiz_input.sendKeys(title);
        time_input.sendKeys(time);
        point_input.sendKeys(point);
        contentQuestion_input.sendKeys(content);
        result_input.sendKeys(result);
    }

    public void clearTXT() {
        titleQiz_input.clear();
        time_input.clear();
        point_input.clear();
        contentQuestion_input.clear();
        result_input.clear();
    }

    public void print() {
        System.out.println("PASSED");
        System.out.println("======================");
        clearTXT();
    }
}
