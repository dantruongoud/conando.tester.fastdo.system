package testcase.Educate.lesson;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import page.Educate.lesson.createLessonPage;
import setupbase.baseSetup;

public class editLessonTest {
    public static void main(String[] args) {
        try {

            createLessonTest[] data_test = {
                    new createLessonTest(1, "", ""),
                    new createLessonTest(2, "Bài giảng", ""),
                    new createLessonTest(3, "Bài giảng", "2")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            createLessonPage lesson = new createLessonPage(driver);

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            index.waitForPageLoaded();

            edit.choseEducate("Automation");
            Thread.sleep(1200);
            edit.choseLesson("Bài giảng");
            index.waitForPageLoaded();

            if (edit.verifyLesson("CHI TIẾT BÀI GIẢNG")) {

                lesson.cleartxt();

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + data_test[i].testcase);
                    lesson.create_lesson(data_test[i].title, data_test[i].time);
                    index.btnComponent.click();
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và thời lượng bải giảng !":
                            System.out.println(noti);
                            lesson.print();
                            break;
                        default:
                            noti = index.messgaeError_tagline();
                            if (noti.equals("Đã cập nhật thông tin bài giảng")) {
                                System.out.println(noti);
                                index.passed();
                            } else {
                                System.out.println(noti);
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
