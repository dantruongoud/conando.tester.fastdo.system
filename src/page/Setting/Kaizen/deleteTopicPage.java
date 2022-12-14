package page.Setting.Kaizen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class deleteTopicPage {
    private WebDriver driver;

    private By tbody = By.xpath("//tbody/tr[1]/td[3]/div[1]/a[2]/i[1]");

    public deleteTopicPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checklist() {
        try {
            WebElement del_btn = driver.findElement(tbody);
            if (del_btn.isDisplayed()) {
                del_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
