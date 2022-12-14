package page.CFRs.Recognition_Star;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class giftStartPage {

    WebDriver driver;

    @FindBy(css = "input[placeholder='Nhập số sao']")
    private WebElement number_input;

    @FindBy(xpath = "//li[@class='column is-one-third']//select")
    private WebElement select_star;

    public giftStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void select() {
        try {
            Select selectbox = new Select(select_star);
            selectbox.selectByValue("3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterNumber(String number) {
        try {
            if (number_input.isDisplayed()) {
                number_input.sendKeys(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cleartxt() {
        number_input.clear();
    }

    public void Stargift(String number) {
        enterNumber(number);
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("======================");
        cleartxt();
    }
}
