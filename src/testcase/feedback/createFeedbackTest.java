package testcase.feedback;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.feedback.createFeedbackPage;
import setupbase.baseSetup;

public class createFeedbackTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createFeedbackPage create = new createFeedbackPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Góp ý hệ thống");

            index.openCorp();
            create.navigation_feedback();
            index.waitForPageLoaded();

            if (index.verifyTitle("Góp ý hệ thống")) {

                index.btnComponent.click();

                for (int i = 1; i < 4; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    create.createFeedback(excel.getCellData("title", i), excel.getCellData("content", i));
                    index.btnComponent.click();

                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Nhập đủ tiêu đề và nội dung !":
                            System.out.println(noti);
                            create.print();
                            break;
                        default:
                            if (noti.equals("Đã gửi góp ý thành công")) {
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
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
