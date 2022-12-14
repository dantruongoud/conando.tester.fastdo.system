package testcase.Setting.Kaizen;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.Kaizen.CreateTopicPage;
import setupbase.baseSetup;

public class CreateTopicTest {
    int testcase;
    String name;

    public CreateTopicTest(int testcase, String name) {
        this.testcase = testcase;
        this.name = name;
    }

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateTopicPage create = new CreateTopicPage(driver);

            index.openCorp();
            index.navigation();
            create.naviga_kaizen();
            index.waitForPageLoaded();

            create.click_create();
            Thread.sleep(1000);

            CreateTopicTest[] data_test = {
                    new CreateTopicTest(1, ""),
                    new CreateTopicTest(2, "name"),
            };

            for (int i = 0; i < data_test.length; i++) {
                System.out.println("=========================");
                System.out.println("Testcase: " + data_test[i].testcase);
                create.create_topic(data_test[i].name);
                Thread.sleep(1000);

                String noti = index.messgaeError_tagline();
                switch (noti) {
                    case "Bạn cần nhập tên chủ đề !":
                        System.out.println(noti);
                        index.passed();
                        break;

                    default:
                        if (create.verifyText()) {
                            System.out.println("Tạo mới thành công");
                            index.passed();
                        } else {
                            index.failed();
                        }
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
