package testcase.Educate;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Educate.createEducatePage;
import setupbase.baseSetup;

public class createEducateTest {
    int testcase;
    String title, number, time;

    public createEducateTest(int testcase, String title, String number, String time) {
        this.testcase = testcase;
        this.title = title;
        this.number = number;
        this.time = time;
    }

    public static void main(String[] args) {
        try {
            createEducateTest[] data_test = {
                    new createEducateTest(1, "", "1", "10"),
                    new createEducateTest(2, "Automation", "0", "10"),
                    new createEducateTest(3, "Automation", "1", "10"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            index.waitForPageLoaded();

            index.btnComponent.click();
            Thread.sleep(2000);

            if (index.verifyTitle("Thông tin khóa học")) {

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    create.createEducate(data_test[i].title, data_test[i].number, data_test[i].time);
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và hình ảnh khóa học !":
                            System.out.println(noti);
                            create.print();
                            Thread.sleep(1000);
                            index.uploadImage("//li[@class='column is-half']//div[@class='control']", "xpath");
                            break;
                        case "Nhập số bài học và thời lượng khóa học !":
                            System.out.println(noti);
                            create.print();
                            break;
                        default:
                            if (create.verifyEducatenew("Automation")) {
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
