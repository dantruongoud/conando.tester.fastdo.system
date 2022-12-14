package page.Setting.Educate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class edit_del_CategoryPage {
    private WebDriver driver;

    @FindBy(css = "input[placeholder='Từ khóa: tên danh mục...']")
    private WebElement search_input;

    @FindBy(xpath = "//span[contains(text(),'Tìm kiếm')]")
    private WebElement search_btn;

    @FindBy(xpath = "/html/body/main/section/section/div[2]/div/table/tbody/tr/td[3]/div/a[1]")
    private WebElement edit_btn;

    @FindBy(xpath = "/html/body/main/section/section/div[2]/div/table/tbody/tr/td[3]/div/a[2]")
    private WebElement delete_btn;

    @FindBy(id = "input_name")
    private WebElement name_input;

    public edit_del_CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearch(String search) {
        try {
            if (search_input.isDisplayed()) {
                search_input.sendKeys(search);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_search() {
        try {
            if (search_btn.isDisplayed()) {
                search_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_edit() {
        try {
            if (edit_btn.isDisplayed()) {
                edit_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_del() {
        try {
            if (delete_btn.isDisplayed()) {
                delete_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        try {
            if (name_input.isDisplayed()) {
                name_input.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyText(String condition) {
        WebElement td = driver.findElement(By.cssSelector(".has-text-weight-semibold"));
        String tdName = td.getText().strip();
        return tdName.equals(condition);
    }
}
