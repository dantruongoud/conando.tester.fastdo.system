package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.Kaizen.CreateKaizenPage;
import setupbase.baseSetup;

public class CreateKaizenTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Kaizen");

            index.openCorp();

            kaizen.navigation_Kaizen();
            index.waitForPageLoaded();

            if (index.verifyTitle("Diễn đàn Kaizen")) {
                index.btnComponent.click();
                Thread.sleep(2000);
                kaizen.chose_catagory("Gia tăng năng suất");
                kaizen.chose_subCategory("Cải thiện cách đánh giá nhân sự");

                for (int i = 1; i < 4; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    kaizen.createKaizen(excel.getCellData("title", i), excel.getCellData("content", i));
                    index.btnComponent.click();
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập đủ tiêu đề và nội dung !":
                            System.out.println(noti);
                            kaizen.print();
                            break;
                        default:
                            noti = index.messgaeError_tagline();
                            if (noti.equals("Đã gửi góp ý Kaizen thành công!")) {
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
