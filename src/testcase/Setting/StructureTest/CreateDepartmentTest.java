package testcase.Setting.StructureTest;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.Setting.StructurePage.CreateDepartmentPage;
import setupbase.baseSetup;

public class CreateDepartmentTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDepartmentPage department = new CreateDepartmentPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Cấu hình - Phòng ban");

            index.openCorp();
            index.navigation();
            Thread.sleep(1000);
            department.navigation_structure();
            index.waitForPageLoaded();

            department.click_createBtn();
            Thread.sleep(1000);

            if (index.verifyTitle("Tạo phòng ban mới")) {

                for (int i = 1; i < 5; i++) {
                    System.out.println("=========================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    department.createDepartment(excel.getCellData("nameDepartment", i), excel.getCellData("manager", i),
                            excel.getCellData("deputy", i));
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Bạn cần nhập đầy đủ thông tin !":
                            System.out.println(noti);
                            department.print();
                            break;
                        default:
                            if (noti.equals("Đã tạo phòng ban " + excel.getCellData("nameDepartment", 2))) {
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
