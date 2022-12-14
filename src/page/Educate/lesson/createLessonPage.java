package page.Educate.lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createLessonPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @FindBy(xpath = "//span[contains(text(),'Thêm bài giảng')]")
    private WebElement naviga;

    @FindBy(css = "input[placeholder='Nhập tiêu đề bài giảng...']")
    private WebElement title_input;

    @FindBy(css = "input[type='number']")
    private WebElement time_input;

    public createLessonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_lesson() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create_lesson(String title, String time) {
        title_input.sendKeys(title);
        time_input.sendKeys(time);
    }

    public void cleartxt() {
        title_input.clear();
        time_input.clear();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        cleartxt();
    }

}
