package testcase.CFRs.Checkin;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.CFRs.Checkin.CreateDraftCheckinPage;
import setupbase.baseSetup;

public class editDraftTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);

            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("CheckinDraft");

            index.openCorp();
            create.navigation_CFRs();
            Thread.sleep(1000);
            create.navigation_checkin();
            index.waitForPageLoaded();

            if (index.verifyTitle("CFRs - Check-in")) {
                create.chose_OKRs("Check-in nháp");
                index.waitForPageLoaded();

                create.click_checkin11();
                Thread.sleep(1000);
                index.btnComponent.click();
                Thread.sleep(1000);
                create.cleartxt();

                for (int i = 1; i < 8; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    create.create_checkin(excel.getCellData("text1", i), excel.getCellData("text2", i),
                            excel.getCellData("text3", i), excel.getCellData("text4", i));
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Chưa nhập mức độ tự tin của Mục tiêu !":
                            System.out.println(noti);
                            create.print();
                            create.selectConfidentOKRs();
                            create.selectConfidentKRs();
                            break;
                        case "Bạn cần nhập đầy đủ tất cả thông tin bắt buộc !":
                            System.out.println(noti);
                            create.print();
                            break;
                        case "Bạn chưa chọn quản lý sẽ check-in với bạn !":
                            System.out.println(noti);
                            create.print();
                            create.research("tan");
                            Thread.sleep(1000);
                            create.click_Usercheckin();
                            index.btnComponent.click();
                            break;
                        default:
                            if (create.verify_checkinDraft()) {
                                System.out.println("Cập nhật Checkin Nháp thành công");
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
