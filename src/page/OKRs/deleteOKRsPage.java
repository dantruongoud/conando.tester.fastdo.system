package page.OKRs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deleteOKRsPage {
    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Xóa']")
    public WebElement delete_btn;

    public deleteOKRsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
