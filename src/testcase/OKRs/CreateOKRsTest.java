package testcase.OKRs;

import org.openqa.selenium.WebDriver;

import page.index;
import page.OKRs.CreateOKRsPage;
import setupbase.baseSetup;

public class CreateOKRsTest {
    int testcase;
    String nameOKRs, nameResult, number, unit;

    public CreateOKRsTest(int testcase, String nameOKRs, String nameResult, String number, String unit) {
        this.testcase = testcase;
        this.nameOKRs = nameOKRs;
        this.nameResult = nameResult;
        this.number = number;
        this.unit = unit;
    }

    public static void main(String[] args) {
        try {
            CreateOKRsTest[] data_test = {
                    new CreateOKRsTest(1, "", "nameResult", "number", "unit"),
                    new CreateOKRsTest(2, "OKRs QUY I", "", "number", "unit"),
                    new CreateOKRsTest(3, "OKRs QUY I", "Hoàn thành OKRs QUÝ I", "", "unit"),
                    new CreateOKRsTest(4, "OKRs QUY I", "Hoàn thành OKRs QUÝ I", "1", ""),
                    new CreateOKRsTest(5, "OKRs QUY I", "Hoàn thành OKRs QUÝ I", "1", "OKRs")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateOKRsPage create = new CreateOKRsPage(driver);

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
                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    
                    System.out.println("Testcase: " + data_test[i].testcase);
                    create.create_OKRs(data_test[i].nameOKRs, data_test[i].nameResult, data_test[i].number,
                            data_test[i].unit);
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
