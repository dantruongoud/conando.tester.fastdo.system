package page.Todolist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatetodolistPage {
    private WebDriver driver;

    @FindBy(css = "a[href='todolist']")
    private WebElement naviga;

    @FindBy(xpath = "//i[normalize-space()='chevron_right']")
    private WebElement nextday_btn;

    @FindBy(xpath = "//span[contains(text(),'Thêm công việc')]")
    private WebElement addWork_btn;

    @FindBy(xpath = "/html/body/main/section/section/div[1]/table/tbody/tr/td/input")
    private WebElement todolist_input;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    @FindBy(css = "a[onclick='taglineHide()']")
    public WebElement delete_Tagline;

    public CreatetodolistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_todolist() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_addWork() {
        try {
            if (addWork_btn.isDisplayed()) {
                addWork_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create_todolist(String todolist) {
        todolist_input.sendKeys(todolist);
        save_btn.click();
    }

    public void click_nextday() {
        try {
            if (nextday_btn.isDisplayed()) {
                nextday_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyText() {
        WebElement td = driver.findElement(By.xpath("//td/span"));
        String tdname = td.getText().strip();
        return tdname.equals("todolist");
    }

    public boolean check_todolist() {
        try {
            String a;
            List<WebElement> tdlist = driver.findElements(By.xpath("//td/span"));
            for (int i = 0; i < tdlist.size(); i++) {
                a = tdlist.get(i).getText().strip();
                if (a.equals("todolist")) {
                    System.out.println("Tạo todolist thành công");
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
