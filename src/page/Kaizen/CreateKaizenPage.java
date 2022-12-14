package page.Kaizen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateKaizenPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @FindBy(css = "a[href='kaizen']")
    private WebElement naviga;

    @FindBy(how = How.XPATH, xpath = "//li[@class='column is-one-third-tablet is-half-mobile']")
    private List<WebElement> category_text;

    @FindBy(how = How.XPATH, xpath = "//li[@class='column is-full']")
    private List<WebElement> category_sub;

    @FindBy(css = "input[placeholder='Nhập tiêu đề..']")
    private WebElement title_input;

    @FindBy(css = "textarea[placeholder='Nhập nội dung góp ý Kaizen của bạn...']")
    private WebElement content_input;

    public CreateKaizenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_Kaizen() {
        try {
            if (naviga.isDisplayed()) {
                naviga.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_subCategory(String condition) {
        try {
            for (int i = 0; i < category_sub.size(); i++) {
                String nameSubcate = category_sub.get(i).getText().strip();
                if (nameSubcate.equals(condition)) {
                    WebElement aTag = category_sub.get(i).findElement(By.tagName("a"));
                    aTag.click();
                    break;
                } else {
                    System.out.println("Failed... Không tìm thấy loại phiếu cần Kaizen");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_catagory(String codition) {
        try {
            for (int i = 0; i < category_text.size(); i++) {
                String nameCate = category_text.get(i).getText().strip();
                System.out.println(nameCate);
                if (nameCate.equals(codition)) {
                    WebElement aTag = category_text.get(i).findElement(By.tagName("a"));
                    aTag.click();
                    break;
                } else {
                    System.out.println("Failed... Không tìm thấy chuyên mục cần Kaizen");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createKaizen(String title, String content) {
        title_input.sendKeys(title);
        content_input.sendKeys(content);
    }

    public void cleartxt() {
        title_input.clear();
        content_input.clear();
    }

    public void print() {
        System.out.println("PASSED");
        System.out.println("======================");
        cleartxt();
    }
}
