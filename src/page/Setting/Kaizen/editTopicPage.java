package page.Setting.Kaizen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editTopicPage {

    WebDriver driver;

    @FindBy(linkText = "name")
    private WebElement choseTopic;

    @FindBy(linkText = "edit")
    private WebElement text;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement topic;

    public editTopicPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_choseTopic() {
        try {
            if (choseTopic.isDisplayed()) {
                choseTopic.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyText() {
        return text.isDisplayed();
    }

    public void clear() {
        try {
            if (topic.isDisplayed()) {
                topic.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
