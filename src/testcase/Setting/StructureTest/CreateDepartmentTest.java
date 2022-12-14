package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.StructurePage.CreateDepartmentPage;
import setupbase.baseSetup;

public class CreateDepartmentTest {
    int testcase;
    String nameDepartment, manager, deputy;

    public CreateDepartmentTest(int testcase, String nameDepartment, String manager, String deputy) {
        this.testcase = testcase;
        this.nameDepartment = nameDepartment;
        this.manager = manager;
        this.deputy = deputy;
    }

    public static void main(String[] args) {
        try {
            CreateDepartmentTest[] data_test = {
                    new CreateDepartmentTest(1, "", "manager", "deputy"),
                    new CreateDepartmentTest(2, "department", "", "deputy"),
                    new CreateDepartmentTest(3, "department", "manager", ""),
                    new CreateDepartmentTest(4, "department", "manager", "deputy"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);

            index.openCorp();
            index.navigation();
            department.navigation_structure();
            index.waitForPageLoaded();

            department.click_createBtn();
            Thread.sleep(1000);

            if (index.verifyTitle("Tạo phòng ban mới")) {

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("=========================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    department.createDepartment(data_test[i].nameDepartment, data_test[i].manager, data_test[i].deputy);
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn cần nhập đầy đủ thông tin !":
                            System.out.println(noti);
                            department.print();
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
