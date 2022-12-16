package testcase.OKRs;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.OKRs.CreateOKRsPage;
import setupbase.baseSetup;

public class CreateOKRsTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateOKRsPage create = new CreateOKRsPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Tạo OKRs");

            index.openCorp();
            create.click_navigation_OKRs();
            Thread.sleep(1000);
            create.click_navigation_CreateOKRs();
            Thread.sleep(1000);
            create.click_navigation_CreatePage();
            Thread.sleep(1000);
            create.click_create();
            index.waitForPageLoaded();

            if (index.verifyTitle("OKRs - Công bố mục tiêu")) {
                for (int i = 1; i < 6; i++) {

                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    create.create_OKRs(excel.getCellData("nameOKRs", i), excel.getCellData("nameResult", i),
                            excel.getCellData("number", i), excel.getCellData("unit", i));
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Nhập các mục tiêu của bạn !":
                            System.out.println(noti);
                            create.print();
                            break;
                        case "Nhập đầy đủ tiêu đề của các kết quả then chốt hoặc xóa kết quả then chốt không cần thiết !":
                            System.out.println(noti);
                            create.print();
                            break;
                        case "Nhập đầy đủ mục tiêu của các kết quả then chốt !":
                            System.out.println(noti);
                            create.print();
                            break;
                        default:
                            if (create.verifyOKRs("OKRs QUY I")) {
                                System.out.println("Tạo mới thành công");
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
