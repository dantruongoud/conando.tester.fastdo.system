package page.Setting.Educate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.Robot;

public class CreateCertificationPage {
    private WebDriver driver;

    @FindBy(css = "a[href='/config/educate/certificate']")
    private WebElement naviga;

    @FindBy(xpath = "/html/body/main/section/section/div[2]/div/ul[1]/li[2]/a/span[2]")
    public WebElement create_btn;

    @FindBy(xpath = "//li[@class='column is-narrow']//div[2]//div[1]")
    private WebElement upfile_btn;

    public CreateCertificationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void uploadFile() {
        try {
            String filePath = "C:\\Users\\Admin\\Downloads\\test3.jpg";

            // Click để mở form upload
            upfile_btn.click();
            Thread.sleep(3000);

            // Khởi tạo Robot class
            Robot rb = null;
            try {
                rb = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            // Copy File path vào Clipboard
            StringSelection str = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

            Thread.sleep(2000);

            // Nhấn Control+V để dán
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);

            Thread.sleep(2000);

            // Nhấn Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            rb.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigation_certification() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
