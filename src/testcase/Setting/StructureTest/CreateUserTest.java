package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.Setting.StructurePage.CreateDepartmentPage;
import page.Setting.StructurePage.CreateUserPage;
import setupbase.baseSetup;

public class CreateUserTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            CreateUserPage createUser = new CreateUserPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Cấu hình - Nhân sự");

            index.openCorp();
            index.navigation();
            Thread.sleep(1000);

            department.navigation_structure();
            createUser.navigation_user();
            index.waitForPageLoaded();

            createUser.click_create();
            Thread.sleep(1000);

            if (index.verifyTitle("Tạo tài khoản mới")) {

                for (int i = 1; i < 7; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    createUser.createUser(excel.getCellData("email", i), excel.getCellData("lastname", i),
                            excel.getCellData("firstname", i), excel.getCellData("password", i));
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
