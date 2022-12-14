package page;

import java.util.List;

import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.AWTException;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class index {

    WebDriver driver;

    @FindBy(css = "input[placeholder='Nhập email...']")
    public WebElement txtUsername;

    @FindBy(css = "input[placeholder='Nhập mật khẩu...']")
    public WebElement txtPassword;

    @FindBy(css = ".button.is-link.is-fullwidth.mb-3")
    public WebElement btnLogin;

    @FindBy(tagName = "form")
    private WebElement frmCorp;

    @FindBy(id = "notify")
    private List<WebElement> tagline;

    @FindBy(css = "a[class='button is-link']")
    public WebElement btnComponent;

    @FindBy(xpath = "//span[contains(text(),'Cấu hình')]")
    private WebElement naviga;

    public index(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        try {
            Thread.sleep(1500);
            txtUsername.sendKeys("ndtruong.conando@gmail.com");
            Thread.sleep(1000);
            txtPassword.sendKeys("dantruong2410");
            Thread.sleep(1000);
            btnLogin.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_Corp() {
        List<WebElement> company = frmCorp.findElements(By.tagName("a"));
        for (WebElement row : company) {
            String list_company = row.getText().strip();
            if (list_company.equals("Do Corp")) {
                row.click();
                break;
            }
        }
    }

    public void openCorp() {
        try {
            login();
            waitForPageLoaded();
            chose_Corp();
            waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void passed() {
        System.out.println("Status: PASSED");
        System.out.println("=========================");
    }

    public void failed() {
        System.out.println("Status: FAILED");
        System.out.println("=========================");
    }

    public String getTitle() {
        return driver.getTitle().strip();
    }

    public boolean verifyTitle(String condition) {
        return getTitle().equals(condition);
    }

    public String messgaeError_tagline() {
        try {
            String validation = "";
            if (tagline.size() > 0) {
                validation = tagline.get(0).getText().strip();
            }
            return validation;
        } catch (Exception e) {
            e.printStackTrace();
            return "Status: Tagline is not Display...";
        }
    }

    public void error_titlePage() {
        System.out.println("Status: FAILED");
        System.out.println("Sai tiêu đề trang hiển thị...");
        System.out.println("=========================");
        driver.close();
    }

    public void uploadImage(String upfile_btn, String typeFind) {
        try {
            WebElement upBtn;
            if (typeFind == "id") {
                upBtn = driver.findElement(By.id(upfile_btn));
            } else if (typeFind == "class") {
                upBtn = driver.findElement(By.className(upfile_btn));
            } else {
                upBtn = driver.findElement(By.xpath(upfile_btn));
            }
            String filePath = "C:\\Users\\Admin\\Downloads\\test3.jpg";

            // Click để mở form upload
            upBtn.click();
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

            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigation() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
