package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.StructurePage.CreateDepartmentPage;
import page.Setting.StructurePage.CreateUserPage;
import setupbase.baseSetup;

public class CreateUserTest {
    int testcase;
    String email, lastname, firstname, password;

    public CreateUserTest(int testcase, String email, String lastname, String firstname, String password) {
        this.testcase = testcase;
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    public static void main(String[] args) {
        try {
            CreateUserTest[] data_test = {
                    new CreateUserTest(1, "", "lastname", "firstname", "password"),
                    new CreateUserTest(2, "email", "lastname", "firstname", "password"),
                    new CreateUserTest(3, "email@gmai.com", "", "firstname", "password"),
                    new CreateUserTest(4, "email@gmai.com", "lastname", "", "password"),
                    new CreateUserTest(5, "email@gmai.com", "lastname", "firstname", ""),
                    new CreateUserTest(6, "email@gmai.com", "lastname", "firstname", "password"),
            };
            
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            CreateUserPage createUser = new CreateUserPage(driver);

            index.openCorp();
            index.navigation();
            Thread.sleep(1000);

            department.navigation_structure();
            createUser.navigation_user();
            index.waitForPageLoaded();

            createUser.click_create();
            Thread.sleep(1000);

            if (index.verifyTitle("Tạo tài khoản mới")) {

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    createUser.createUser(data_test[i].email, data_test[i].lastname, data_test[i].firstname,
                            data_test[i].password);
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn chưa nhập địa chỉ email, hoặc địa chỉ email không đúng !":
                            System.out.println(noti);
                            createUser.print();
                            break;
                        case "Bạn chưa nhập họ và tên cho tài khoản !":
                            System.out.println(noti);
                            createUser.print();
                            break;
                        case "Bạn chưa nhật mật khẩu cho tài khoản !":
                            System.out.println(noti);
                            createUser.print();
                            break;
                        default:
                            noti = index.messgaeError_tagline();
                            if (noti != null) {
                                System.out.println(noti);
                                index.passed();
                            } else {
                                index.failed();
                            }
                            break;
                    }
                    Thread.sleep(1200);
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
