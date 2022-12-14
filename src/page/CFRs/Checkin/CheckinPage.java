package page.CFRs.Checkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckinPage {

    private WebDriver driver;

    @FindBy(css = "input[placeholder='Nhập phản hồi...']")
    private WebElement repply_input;

    @FindBy(xpath = "/html/body/main/section/section/div[2]/div/div/div[2]/div/input")
    private WebElement next_checkin;

    @FindBy(css = "a[class='button is-link']")
    private WebElement create_btn;

    public CheckinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void textRepply(String repply, String day) {
        try {
            repply_input.sendKeys(repply);
            next_checkin.sendKeys(day);
            Thread.sleep(1000);
            create_btn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleatTXT() {
        repply_input.clear();
        next_checkin.clear();
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        cleatTXT();
    }

    public boolean verifyButton() {
        try {
            WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Tạo Check-in nháp')]"));
            return button.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
