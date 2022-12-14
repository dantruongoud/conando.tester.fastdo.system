package page.Kaizen;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class repplyKaizenPage {
    public WebDriver driver;

    @FindBy(id = "replyInput")
    private WebElement content_input;

    @FindBy(how = How.CSS, css = "div[class='content']")
    private List<WebElement> contenttext;

    public repplyKaizenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterContent(String content) {
        try {
            if (content_input.isDisplayed()) {
                content_input.sendKeys(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyContent(String condition) {
        try {
            String getText = "";
            for (WebElement row : contenttext) {
                getText = row.getText().strip();
                System.out.println(getText);
                break;
            }
            return getText.equals(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
