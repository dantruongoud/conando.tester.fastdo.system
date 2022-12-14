package page.OKRs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class editOKRsPage {
    private WebDriver driver;

    public editOKRsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chose_OKRsedit(String nameOKRs) {
        try {
            List<WebElement> trlist = driver.findElements(By.tagName("tr"));
            for (int i = 0; i < trlist.size(); i++) {
                List<WebElement> tdlist = trlist.get(i).findElements(By.tagName("td"));
                if (tdlist.size() == 5) {
                    WebElement td = tdlist.get(0);
                    String tdname = td.getText().strip();
                    if (tdname.equals(nameOKRs)) {
                        WebElement aTag = tdlist.get(0).findElement(By.tagName("a"));
                        aTag.click();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
