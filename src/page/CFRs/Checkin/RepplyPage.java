package page.CFRs.Checkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class RepplyPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Phản hồi')]")
    private WebElement naviga;

    @FindBy(id = "replyInput")
    private WebElement repply_input;

    @FindBy(css = "a[title='Đính kèm hình ảnh']")
    private WebElement upload;

    public RepplyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_repply() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterRepply(String repply) {
        try {
            if (repply_input.isDisplayed()) {
                repply_input.sendKeys(repply);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadImage() {
        try {
            if (upload.isDisplayed()) {
                String filePath = "C:\\Users\\Admin\\Downloads\\test3.jpg";

                // Click để mở form upload
                upload.click();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyCmt(String a) {
        try {
            String get = "";
            List<WebElement> comment = driver
                    .findElements(By.className("column is-three-fifths-tablet is-full-mobile"));
            for (int i = 0; i < comment.size(); i++) {
                get = comment.get(i).getText().strip();
                System.out.println(get);
            }
            return get.equals(a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
