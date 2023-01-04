package page.OKRs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOKRsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='OKRs']")
    public WebElement naviga_OKRs_btn;

    @FindBy(xpath = "//span[contains(text(),'Thiết lập')]")
    public WebElement naviga_create_btn;

    @FindBy(xpath = "//span[contains(text(),'Tạo OKRs')]")
    public WebElement naviga_CreatePage;

    @FindBy(css = "a[class='button']")
    private WebElement create_btn;

    @FindBy(xpath = "//input[@class='input has-text-weight-semibold is_bg']")
    private WebElement nameOKRs_input;

    @FindBy(css = "a[class='button is-link']")
    private WebElement save_btn;

    @FindBy(css = "div[class='control is-expanded'] input[placeholder='Bắt buộc nhập...']")
    private WebElement nameResult_input;

    @FindBy(css = "input[placeholder='Nhập số liệu mục tiêu']")
    private WebElement number_input;

    @FindBy(css = "input[placeholder='Đơn vị tính']")
    private WebElement unit_input;

    public CreateOKRsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_OKRsPage() {
        try {
            naviga_OKRs_btn.click();
            Thread.sleep(500);
            naviga_create_btn.click();
            Thread.sleep(500);
            naviga_CreatePage.click();
            Thread.sleep(500);
            create_btn.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigation_OKRsPageEdit() {
        try {
            naviga_OKRs_btn.click();
            Thread.sleep(500);
            naviga_create_btn.click();
            Thread.sleep(500);
            naviga_CreatePage.click();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create_OKRs(String nameOKRs, String nameResult, String number, String unit) {
        nameOKRs_input.sendKeys(nameOKRs);
        nameResult_input.sendKeys(nameResult);
        number_input.sendKeys(number);
        unit_input.sendKeys(unit);
        save_btn.click();
    }

    public void cleartxt() {
        nameOKRs_input.clear();
        nameResult_input.clear();
        number_input.clear();
        unit_input.clear();
    }

    public void print() {
        System.out.println("PASSED");
        System.out.println("======================");
        cleartxt();
    }

    public boolean verifyOKRs(String a) {
        try {
            String tdname = null;
            List<WebElement> trlist = driver.findElements(By.tagName("tr"));
            for (int i = 0; i < trlist.size(); i++) {
                List<WebElement> tdlist = trlist.get(i).findElements(By.tagName("td"));
                if (tdlist.size() == 5) {
                    WebElement td = tdlist.get(0);
                    tdname = td.getText().strip();
                    System.out.println(tdname);
                    break;
                }
            }
            return tdname.equals(a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
