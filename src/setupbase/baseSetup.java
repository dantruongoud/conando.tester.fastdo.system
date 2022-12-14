package setupbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import page.index;

public class baseSetup {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    // Khởi tạo cấu hình của Browser
    public WebDriver initChromeDriver() {

        ChromeOptions useragent = new ChromeOptions();
        index index = new index(driver);
        useragent.addArguments("disable-notifications");

        driver = new ChromeDriver(useragent);

        System.out.println("Launching Chrome browser...");
        driver.manage().window().maximize();
        driver.get("https://work.fastdo.vn/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        index.waitForPageLoaded();
        return driver;
    }
}