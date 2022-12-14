package page.Setting.Kaizen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTopicPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@href='config/kaizen']")
    private WebElement kaizen;

    @FindBy(css = ".button.is-small")
    private WebElement create_btn;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement topic;

    @FindBy(xpath = "//a[@class='button is-link']")
    private WebElement save_btn;

    public CreateTopicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void naviga_kaizen() {
        try {
            if (kaizen.isDisplayed()) {
                kaizen.click();
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

    public void create_topic(String name) {
        topic.sendKeys(name);
        save_btn.click();
    }

    public boolean verifyText() {
        WebElement text = driver.findElement(By.linkText("name"));
        return text.isDisplayed();
    }
}
