package page.CFRs.Checkin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateDraftCheckinPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='CFRs']")
    private WebElement naviga;

    @FindBy(xpath = "//span[normalize-space()='Check-in']")
    private WebElement checkin_btn;

    @FindBy(xpath = "//a[normalize-space()='Check-in1:1']")
    private WebElement checkin11_btn;

    @FindBy(css = "a[class='button is-link']")
    private WebElement create_btn;

    @FindBy(xpath = "(//select)[1]")
    private WebElement selectConfident_OKRs;

    @FindBy(xpath = "(//select)[2]")
    private WebElement selectConfident_KRs;

    @FindBy(css = "li:nth-child(1) > div:nth-child(2) > textarea:nth-child(1)")
    private WebElement text1_input;

    @FindBy(css = "li:nth-child(2) > div:nth-child(2) > textarea:nth-child(1)")
    private WebElement text2_input;

    @FindBy(css = "li:nth-child(3) > div:nth-child(2) > textarea:nth-child(1)")
    private WebElement text3_input;

    @FindBy(css = "li:nth-child(4) > div:nth-child(2) > textarea:nth-child(1)")
    private WebElement text4_input;

    @FindBy(css = "input[placeholder='Nhập tên nhân viên...']")
    private WebElement search_input;

    @FindBy(className = "user_item")
    private WebElement chose_checkin;

    public CreateDraftCheckinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_CFRs() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigation_checkin() {
        try {
            if (checkin_btn.isDisplayed()) {
                checkin_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_checkin11() {
        try {
            if (checkin11_btn.isDisplayed()) {
                checkin11_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_OKRs(String condition) {
        try {
            List<WebElement> trlist = driver.findElements(By.xpath("//tbody/tr"));
            for (int i = 0; i < trlist.size(); i++) {
                List<WebElement> tdlist = trlist.get(i).findElements(By.tagName("td"));
                if (tdlist.size() == 7) {
                    WebElement td = tdlist.get(6);
                    String tdname = td.getText().strip();
                    System.out.println(tdname);
                    if (tdname.equals(condition)) {
                        WebElement aTag = tdlist.get(0).findElement(By.tagName("a"));
                        aTag.click();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectConfidentOKRs() {
        try {
            Select confident_btn = new Select(selectConfident_OKRs);
            confident_btn.selectByVisibleText("Ổn");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectConfidentKRs() {
        try {
            Select confident_btn = new Select(selectConfident_KRs);
            confident_btn.selectByVisibleText("Ổn");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void research(String search) {
        try {
            if (search_input.isDisplayed()) {
                search_input.sendKeys(search);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearSearch() {
        search_input.clear();
    }

    public void click_Usercheckin() {
        try {
            if (chose_checkin.isDisplayed()) {
                chose_checkin.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        text1_input.clear();
        text2_input.clear();
        text3_input.clear();
        text4_input.clear();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        cleartxt();
    }

    public void create_checkin(String text1, String text2, String text3, String text4) {
        try {
            text1_input.sendKeys(text1);
            text2_input.sendKeys(text2);
            text3_input.sendKeys(text3);
            text4_input.sendKeys(text4);
            Thread.sleep(1000);
            create_btn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verify_checkinDraft() {
        try {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Sửa bản nháp')]"));
            return button.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
