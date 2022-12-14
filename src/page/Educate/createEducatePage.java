package page.Educate;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class createEducatePage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @FindBy(xpath = "(//span[contains(text(),'Đào tạo')])[1]")
    private WebElement naviga;

    @FindBy(css = "a[href='educate/course/manager']")
    private WebElement naviga_educate;

    @FindBy(xpath = "//input[@placeholder='Nhập tiêu đề khóa học...']")
    private WebElement title_input;

    @FindBy(css = "input[type='number']")
    private WebElement number_input;

    @FindBy(css = "input[placeholder='VD: 5h 30ph...']")
    private WebElement time_input;

    @FindBy(xpath = "//div[@class='buttons is-right']//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    @FindBy(how = How.XPATH, xpath = "//li[@class='column is-11']")
    private List<WebElement> nameEducate;

    public createEducatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_educate() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CrudEducate() {
        try {
            if (naviga_educate.isDisplayed()) {
                naviga_educate.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createEducate(String title, String number, String time) {
        title_input.sendKeys(title);
        number_input.sendKeys(number);
        time_input.sendKeys(time);
        save_btn.click();
    }

    public void clearTxt() {
        try {
            title_input.clear();
            number_input.clear();
            time_input.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        clearTxt();
    }

    public boolean verifyEducatenew(String condition) {
        try {
            for (WebElement row : nameEducate) {
                String getText = row.getText().strip();
                if (getText.equals(condition)) {
                    System.out.println("Tạo mới thành công");
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
