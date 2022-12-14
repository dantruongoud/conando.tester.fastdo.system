package testcase.Setting.Kaizen;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Kaizen.CreateTopicPage;
import page.Setting.Kaizen.editTopicPage;
import setupbase.baseSetup;

public class editTopicTest {
    int testcase;
    String name;

    public editTopicTest(int testcase, String name) {
        this.testcase = testcase;
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            using.login();
            using.navigation();
            CreateTopicPage create = new CreateTopicPage(driver);
            create.naviga_kaizen();
            using.waitForPageLoaded();
            editTopicPage edit = new editTopicPage(driver);
            edit.click_choseTopic();
            Thread.sleep(1000);
            edit.clear();
            editTopicTest[] data_test = {
                    new editTopicTest(1, ""),
                    new editTopicTest(2, "edit"),
            };
            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                create.create_topic(data_test[i].name);
                Thread.sleep(1000);
                String noti = using.messgaeError_tagline();
                switch (noti) {
                    case "Bạn cần nhập tên chủ đề !":
                        System.out.println(noti);
                        System.out.println("PASSED");
                        System.out.println("=========================");
                        break;

                    default:
                        if (edit.verifyText()) {
                            System.out.println("Cập nhật thành công");
                            using.passed();
                        } else {
                            using.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
