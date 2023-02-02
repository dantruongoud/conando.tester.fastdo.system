package page.Setting.OKRs_CFRsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cyclePage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement create_btn;

    @FindBy(css = "input[class='input']")
    private WebElement cycleName_input;

    @FindBy(xpath = "//div[@class='field is-grouped']/div[1]//input[1]")
    private WebElement start_input;

    @FindBy(xpath = "/html/body/main/section/div/div[2]/form/div[3]/div[3]/div/div/input")
    private WebElement end_input;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    @FindBy(css = "a[href='config/okrs']")
    private WebElement naviga;

    @FindBy(css = ".has-text-weight-semibold")
    private WebElement namecycle;

    public cyclePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        return namecycle.getText().strip();
    }

    public boolean verifycyclenew() {
        String a = "Cycle";
        return getText().equals(a);
    }

    public void navigation_OKRs_CFRs() {
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

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifytitle() {
        String a = "Cấu hình chu kỳ";
        return getTitle().equals(a);
    }

    public void create_cycle(String cycleName, String day) {
        cycleName_input.sendKeys(cycleName);
        start_input.sendKeys(day);
        save_btn.click();
    }

    public void print() {
        System.out.println("PASSED");
        System.out.println("=========================");
        cleartxt();
    }

    public void cleartxt() {
        cycleName_input.clear();
        start_input.clear();
    }

}
