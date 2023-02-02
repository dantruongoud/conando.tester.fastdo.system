package page.CFRs.Recognition_Star;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class recognitonPage {

    public String[] tagline = {
            "Bạn chưa chọn người nhận !",
            "Bạn không thể ghi nhận - tặng sao cho chính mình !",
            "Bạn chưa chọn tiêu chí ghi nhận !",
            "Bạn chưa nhập nội dung !"
    };

    WebDriver driver;

    @FindBy(css = "a[href='cfr/star']")
    private WebElement naviga;

    @FindBy(xpath = "/html/body/main/section/section/ul/li[1]/div/ul/li[5]/div[2]/div/div/select")
    private WebElement select_tieuchi;

    @FindBy(css = "textarea[placeholder='Nhập nội dung...']")
    private WebElement content_input;

    public recognitonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void navigation_recognition() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        try {
            Select selectbox = new Select(select_tieuchi);
            selectbox.selectByVisibleText("A (0)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterContent(String content) {
        try {
            if (content_input.isDisplayed()) {
                content_input.sendKeys(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recognition(String content) {
        enterContent(content);
    }

    public void clear() {
        content_input.clear();
    }
}
