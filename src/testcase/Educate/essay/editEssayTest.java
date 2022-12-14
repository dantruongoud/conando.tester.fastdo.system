package testcase.Educate.essay;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import page.Educate.essay.createEssayPage;
import setupbase.baseSetup;

public class editEssayTest {
    public static void main(String[] args) {
        try {
            createEssayTest[] data_test = {
                    new createEssayTest(1, "", "", "", "content"),
                    new createEssayTest(2, "Bài thi tự luận", "", "", "content"),
                    new createEssayTest(3, "Bài thi tự luận", "1", "", "content"),
                    new createEssayTest(4, "Bài thi tự luận", "1", "2", "content"),
                    new createEssayTest(5, "Bài thi tự luận", "1", "-2", "content"),
                    new createEssayTest(6, "Bài thi tự luận", "1", "1", ""),
                    new createEssayTest(7, "Bài thi tự luận", "1", "1", "content")
            };

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            createEssayPage essay = new createEssayPage(driver);

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            index.waitForPageLoaded();

            edit.choseEducate("Automation");
            Thread.sleep(1200);
            edit.choseLesson("Bài thi tự luận");
            index.waitForPageLoaded();

            if (edit.verifyLesson("CHI TIẾT BÀI TỰ LUẬN")) {
                essay.clearTXT();
                Thread.sleep(1000);

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    essay.createEssay(data_test[i].title, data_test[i].time, data_test[i].point, data_test[i].content);
                    index.btnComponent.click();
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();
                    switch (noti) {
                        case "Nhập tiêu đề và thời lượng bài tự luận !":
                            System.out.println(noti);
                            essay.print();
                            break;
                        case "Giá trị mức điểm đạt phải lớn hơn hoặc bằng 1 !":
                            System.out.println(noti);
                            essay.print();
                            break;
                        case "Mức điểm đạt được của bài thi phải nhỏ hơn tổng điểm bài thi !":
                            System.out.println(noti);
                            essay.print();
                            break;
                        case "Có câu hỏi chưa nhập nội dung !":
                            System.out.println(noti);
                            essay.print();
                            break;
                        default:
                            noti = index.messgaeError_tagline();
                            if (noti.equals("Đã cập nhật thông tin bài tự luận !")) {
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
