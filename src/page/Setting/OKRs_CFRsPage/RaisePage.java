package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RaisePage {

    WebDriver driver;

    @FindBy(css = "a[href='/config/okrs/suggests']")
    private WebElement naviga;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement create_btn;

    @FindBy(tagName = "input")
    private WebElement nameRaise;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    public WebElement save_btn;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement text_new;

    public RaisePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String gettext() {
        return text_new.getText().strip();
    }

    public boolean verifyText() {
        return gettext().equals("A");
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

    public void createRaise(String name) {
        nameRaise.sendKeys(name);
        save_btn.click();
    }

    public void navigatoRaise() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
