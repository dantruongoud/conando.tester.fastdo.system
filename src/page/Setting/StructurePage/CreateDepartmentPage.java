package page.Setting.StructurePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDepartmentPage {

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Cơ cấu')]")
    private WebElement naviga_structure;

    @FindBy(xpath = "//span[contains(text(),'Thêm mới')]")
    private WebElement add_btn;

    @FindBy(xpath = "//form[1]/div[1]//input[@class='input']")
    private WebElement nameDepartment_input;

    @FindBy(xpath = "//input[@placeholder='Nhập chức danh quản lý, không quá 20 ký tự']")
    private WebElement manager_input;

    @FindBy(xpath = "//input[@placeholder='Nhập chức phó danh quản lý, không quá 20 ký tự']")
    private WebElement deputy_manager_input;

    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    private WebElement save_btn;

    public CreateDepartmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigation_structure() {
        try {
            if (naviga_structure.isDisplayed()) {
                naviga_structure.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click_createBtn() {
        try {
            if (add_btn.isDisplayed()) {
                add_btn.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("Status: PASSED");
        System.out.println("=========================");
        cleartxt();
    }

    public void cleartxt() {
        nameDepartment_input.clear();
        manager_input.clear();
        deputy_manager_input.clear();
    }

    public void createDepartment(String nameDepartment, String manager, String deputy) {
        nameDepartment_input.sendKeys(nameDepartment);
        manager_input.sendKeys(manager);
        deputy_manager_input.sendKeys(deputy);
        save_btn.click();
    }
}
