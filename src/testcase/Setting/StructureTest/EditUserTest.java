package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.StructurePage.CreateDepartmentPage;
import page.Setting.StructurePage.CreateUserPage;
import page.Setting.StructurePage.EditUserPage;
import setupbase.baseSetup;

public class EditUserTest {
    int testcase;
    String lastname, firstname;

    public EditUserTest(int testcase, String lastname, String firstname) {
        this.testcase = testcase;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public static void main(String[] args) {
        try {
            EditUserTest[] data_test = {
                    new EditUserTest(1, "", "firstname"),
                    new EditUserTest(2, "lastname", ""),
                    new EditUserTest(3, "lastname", "firstname"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            CreateUserPage createUser = new CreateUserPage(driver);
            EditUserPage edit = new EditUserPage(driver);

            index.openCorp();
            index.navigation();
            Thread.sleep(1000);
            department.navigation_structure();
            createUser.navigation_user();
            index.waitForPageLoaded();

            edit.enterSearch("truong");
            index.waitForPageLoaded();

            edit.chose_user.click();
            Thread.sleep(1200);
            edit.cleartxt();
            index.waitForPageLoaded();

            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                edit.editUser(data_test[i].lastname, data_test[i].firstname);
                Thread.sleep(1000);

                String noti = index.messgaeError_tagline();
                switch (noti) {
                    case "Bạn chưa nhập họ và tên cho tài khoản!":
                        System.out.println(noti);
                        index.passed();
                        edit.cleartxt();
                        break;
                    default:
                        noti = index.messgaeError_tagline();
                        if (noti.equals("Đã cập nhật thông tin thành công!")) {
                            System.out.println(noti);
                            index.passed();
                        } else {
                            System.out.println(noti);
                            index.failed();
                        }
                        break;
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
