package testcase.Educate;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import setupbase.baseSetup;

public class editEducateTest {
    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Tạo khoá học");

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            index.waitForPageLoaded();

            if (index.verifyTitle("Quản lý khóa học")) {
                edit.choseEducate("Automation");
                index.waitForPageLoaded();
                index.btnComponent.click();
                index.waitForPageLoaded();

                create.clearTxt();

                for (int i = 1; i < 4; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    create.createEducate(excel.getCellData("title", i), excel.getCellData("number", i),
                            excel.getCellData("time", i));
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và hình ảnh khóa học !":
                            System.out.println(noti);
                            create.print();
                            Thread.sleep(1000);
                            break;
                        case "Nhập số bài học và thời lượng khóa học !":
                            System.out.println(noti);
                            create.print();
                            break;
                        default:
                            if (create.verifyEducatenew("Automation Edit")) {
                                System.out.println("Chỉnh sửa thành công");
                                index.passed();
                            } else {
                                index.failed();
                            }
                            break;
                    }
                    Thread.sleep(1000);
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
