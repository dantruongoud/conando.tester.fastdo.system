package testcase.Educate.qiz;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import page.Educate.qiz.createQizPage;
import setupbase.baseSetup;

public class editQizTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            createQizPage qiz = new createQizPage(driver);

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            index.waitForPageLoaded();

            edit.choseEducate("Automation");
            Thread.sleep(1200);
            edit.choseLesson("Bài thi trắc nghiệm");
            index.waitForPageLoaded();

            if (edit.verifyLesson("CHI TIẾT BÀI TRẮC NGHIỆM")) {
                qiz.clearTXT();
                Thread.sleep(1000);

                createQizTest[] data_test = {
                        new createQizTest(1, "", "", "0", "content", "result"),
                        new createQizTest(2, "Bài thi trắc nghiệm", "", "0", "content", "result"),
                        new createQizTest(3, "Bài thi trắc nghiệm", "1", "0", "content", "result"),
                        new createQizTest(4, "Bài thi trắc nghiệm", "1", "-1", "Content", "result"),
                        new createQizTest(5, "Bài thi trắc nghiệm", "1", "2", "content", "result"),
                        new createQizTest(6, "Bài thi trắc nghiệm", "1", "1", "", "result"),
                        new createQizTest(7, "Bài thi trắc nghiệm", "1", "1", "Content", ""),
                        new createQizTest(8, "Bài thi trắc nghiệm", "1", "1", "Content", "result"),
                };

                for (int i = 0; i < data_test.length; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + data_test[i].testcase);
                    qiz.create_qiz(data_test[i].title, data_test[i].time, data_test[i].point, data_test[i].content,
                            data_test[i].result);
                    index.btnComponent.click();
                    Thread.sleep(1200);

                    String noti = index.messgaeError_tagline();

                    switch (noti) {
                        case "Nhập tiêu đề và thời lượng bài trắc nghiệm !":
                            System.out.println(noti);
                            qiz.print();
                            break;
                        case "Giá trị mức điểm đạt phải lớn hơn hoặc bằng 1 !":
                            System.out.println(noti);
                            qiz.print();
                            break;
                        case "Mức điểm đạt được của bài thi phải nhỏ hơn tổng điểm bài thi !":
                            System.out.println(noti);
                            qiz.print();
                            break;
                        case "Có câu hỏi chưa nhập nội dung, vui lòng nhập nội dung cho câu hỏi":
                            System.out.println(noti);
                            qiz.print();
                            break;
                        case "Có đáp án chưa có nội dung, vui lòng nhập nội dung cho đáp án !":
                            System.out.println(noti);
                            qiz.print();
                            break;
                        // Khi sửa thì trường hợp này luôn luôn đúng nên k cần check
                        // case "Có câu hỏi chưa có đáp án đúng, vui lòng chọn 1 đáp án đúng cho câu hỏi
                        // !":
                        // System.out.println(noti);
                        // qiz.check_checkbox();
                        // qiz.print();
                        // break;
                        default:
                        
                            noti = index.messgaeError_tagline();
                            if (noti.equals("Đã cập nhật thông tin bài trắc nghiệm !")) {
                                System.out.println(noti);
                                System.out.println("PASSED");
                                System.out.println("======================");
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
