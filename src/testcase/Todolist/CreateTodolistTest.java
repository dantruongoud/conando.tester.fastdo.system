package testcase.Todolist;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Todolist.CreatetodolistPage;
import setupbase.baseSetup;

public class CreateTodolistTest {
    int testcase;
    String todolist;

    public CreateTodolistTest(int testcase, String todolist) {
        this.testcase = testcase;
        this.todolist = todolist;
    }

    public static void main(String[] args) {
        try {
            CreateTodolistTest[] data_test = {
                    new CreateTodolistTest(1, ""),
                    new CreateTodolistTest(2, "todolist")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreatetodolistPage create = new CreatetodolistPage(driver);

            index.openCorp();
            create.navigation_todolist();
            index.waitForPageLoaded();

            if (index.verifyTitle("Todolist của tôi")) {

                create.click_nextday();
                Thread.sleep(1500);
                create.click_addWork();

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    Thread.sleep(1000);
                    create.create_todolist(data_test[i].todolist);

                    Thread.sleep(1000);
                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Bạn chưa nhập tên công việc !":
                            System.out.println(noti);
                            index.passed();
                            create.delete_Tagline.click();
                            break;
                        default:
                            if (create.check_todolist()) {
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
