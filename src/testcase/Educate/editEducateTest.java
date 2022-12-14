package testcase.Educate;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import setupbase.baseSetup;

public class editEducateTest {
    public static void main(String[] args) {
        try {
            createEducateTest[] data_test = {
                    new createEducateTest(1, "", "1", "10"),
                    new createEducateTest(2, "Automation Edit", "0", "10"),
                    new createEducateTest(3, "Automation Edit", "1", "10"),
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);

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
                            break;
                        case "Nhập số bài học và thời lượng khóa học !":
                            System.out.println(noti);
                            create.print();
                            break;
                        default:
                            if (create.verifyEducatenew("Automation Edit")) {
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
