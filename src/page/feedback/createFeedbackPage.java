package page.feedback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createFeedbackPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @FindBy(css = "a[href='feedback']")
    private WebElement naviga;

    @FindBy(css = "input[placeholder='Nhập tiêu đề..']")
    private WebElement title_input;

    @FindBy(tagName = "textarea")
    private WebElement content_input;

    public createFeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_feedback() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFeedback(String title, String content) {
        title_input.sendKeys(title);
        content_input.sendKeys(content);
    }

    public void clear() {
        title_input.clear();
        content_input.clear();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        clear();
    }
}
