package page.Educate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class editEducatePage {
    
    private WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//li[@class='column is-11']")
    private List<WebElement> nameEducate;

    @FindBy(css = ".button.is-white.has-text-link")
    private WebElement addQuestion_btn;

    @FindBy(tagName = "h1")
    private WebElement title_page;

    public editEducatePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addQuestion() {
        try {
            if (addQuestion_btn.isDisplayed()) {
                addQuestion_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseEducate(String condition) {
        try {
            for (int i = 0; i < nameEducate.size(); i++) {
                String getText = nameEducate.get(i).getText().strip();
                if (getText.equals(condition)) {
                    WebElement aTag = nameEducate.get(i).findElement(By.tagName("a"));
                    aTag.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title_page.getText().strip();
    }

    public boolean verifyLesson(String condition) {
        try {
            return getTitle().equals(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void choseLesson(String condition) {
        try {
            List<WebElement> trlist = driver.findElements(By.tagName("tr"));
            for (int i = 0; i < trlist.size(); i++) {
                List<WebElement> tdlist = trlist.get(i).findElements(By.tagName("td"));
                if (tdlist.size() == 5) {
                    WebElement td = tdlist.get(0);
                    String lesson = td.getText().strip();
                    if (lesson.equals(condition)) {
                        WebElement aTag = tdlist.get(0).findElement(By.tagName("a"));
                        aTag.click();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
