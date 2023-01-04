package testcase.OKRs;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.OKRs.CreateOKRsPage;
import page.OKRs.editOKRsPage;
import setupbase.baseSetup;

public class editOKRsTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateOKRsPage create = new CreateOKRsPage(driver);
            editOKRsPage edit = new editOKRsPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Tạo OKRs");

            index.openCorp();
            create.navigation_OKRsPageEdit();
            
            edit.chose_OKRsedit("OKRs QUY I");
            index.waitForPageLoaded();
            create.cleartxt();

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
                            System.out.println("Chỉnh sửa thành công");
                            index.passed();
                        } else {
                            index.failed();
                        }
                        break;
                }

                Thread.sleep(1200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
