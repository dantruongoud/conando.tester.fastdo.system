package page.Setting.Educate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
    
    private WebDriver driver;

    @FindBy(css = "a[href='config/educate']")
    public WebElement naviga;

    @FindBy(xpath = "//a[@class='button is-link']")
    private WebElement create_btn;

    @FindBy(id = "input_name")
    private WebElement name_input;

    @FindBy(css = "div[class='buttons is-right'] a[class='button is-link']")
    private WebElement save_btn;

    public CreateCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void enterName(String name) {
        try {
            if (name_input.isDisplayed()) {
                name_input.sendKeys(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_save() {
        try {
            if (save_btn.isDisplayed()) {
                save_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyText() {
        WebElement td = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        String tdName = td.getText().strip();
        return tdName.equals("AAAA");
    }
}
