package testcase.CFRs.Checkin;

import org.openqa.selenium.WebDriver;

import page.index;
import page.CFRs.Checkin.CreateDraftCheckinPage;
import setupbase.baseSetup;

public class editDraftTest {

    public static void main(String[] args) {
        try {

            CreateDraftCheckinTest[] data_test = {
                    new CreateDraftCheckinTest(1, "", "", "", ""),
                    new CreateDraftCheckinTest(2, "Tiến độ tốt", "Không có", "Chưa có", "Không có"),
                    new CreateDraftCheckinTest(3, "", "Chưa có", "Chưa có", "Chưa có"),
                    new CreateDraftCheckinTest(4, "Chưa có", "", "Chưa có", "Chưa có"),
                    new CreateDraftCheckinTest(5, "Chưa có", "Chưa có", "", "Chưa có"),
                    new CreateDraftCheckinTest(6, "Tiến độ tốt", "Không có", "Chưa có",
                            ""),
                    new CreateDraftCheckinTest(7, "Tiến độ tốt", "Không có", "Chưa có",
                            "Không có"),
            };
            
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateDraftCheckinPage create = new CreateDraftCheckinPage(driver);

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

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    create.create_checkin(data_test[i].text1, data_test[i].text2,
                            data_test[i].text3,
                            data_test[i].text4);

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
