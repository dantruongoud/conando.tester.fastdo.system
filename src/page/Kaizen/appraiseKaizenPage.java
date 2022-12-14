package page.Kaizen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class appraiseKaizenPage {
    
    private WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//a[@class='has-text-weight-semibold is-size-6']")
    private List<WebElement> kaizen;

    @FindBy(xpath = "//div[@class='dropdown-trigger']//span[@class='icon']")
    private WebElement menu;

    @FindBy(xpath = "//a[contains(text(),'Đánh giá Kaizen')]")
    private WebElement appraise_btn;

    @FindBy(css = ".is-block.has-text-centered.has-text-link")
    private WebElement criteria_btn;

    @FindBy(xpath = "//span[contains(text(),'Xác nhận')]")
    private WebElement save_btn;

    public appraiseKaizenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void chose_Kaizen(String condition) {
        try {
            for (int i = 0; i < kaizen.size(); i++) {
                String nameKaizen = kaizen.get(i).getText().strip();
                if (nameKaizen.equals(condition)) {
                    kaizen.get(i).click();
                    break;
                } else {
                    System.out.println("Failed...Không tìm thấy kaizen cần đánh giá");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_menu() {
        try {
            if (menu.isDisplayed()) {
                menu.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_submenu() {
        try {
            if (appraise_btn.isDisplayed()) {
                appraise_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_criteria() {
        try {
            if (criteria_btn.isDisplayed()) {
                criteria_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String verify_appraise() {
        try {
            String name_status = "";
            List<WebElement> status = driver.findElements(By.xpath("//li[3]/span/span[2]"));
            for (int i = 0; i < status.size(); i++) {
                name_status = status.get(i).getText().strip();
            }
            return name_status;
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed...";
        }
    }

    public void click_save() {
        try {
            if (save_btn.isDisplayed()) {
                save_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
