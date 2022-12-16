package testcase.Educate.qiz;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import page.Educate.qiz.createQizPage;
import setupbase.baseSetup;

public class createQizTest {

    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            createQizPage qiz = new createQizPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Bài thi trắc nghiệm");

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);
            create.CrudEducate();
            index.waitForPageLoaded();

            edit.choseEducate("Automation");
            Thread.sleep(1200);
            qiz.navigation_qiz();
            index.waitForPageLoaded();

            if (edit.verifyLesson("CHI TIẾT BÀI TRẮC NGHIỆM")) {

                edit.addQuestion();
                Thread.sleep(1000);

                for (int i = 1; i < 10; i++) {
                    System.out.println("======================");

                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    qiz.create_qiz(excel.getCellData("title", i), excel.getCellData("time", i),
                            excel.getCellData("point", i), excel.getCellData("content", i),
                            excel.getCellData("result", i));
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
                        case "Có câu hỏi chưa có đáp án đúng, vui lòng chọn 1 đáp án đúng cho câu hỏi !":
                            System.out.println(noti);
                            qiz.checkbox_check.click();
                            qiz.print();
                            break;
                        default:
                            if (noti.equals("Đã cập nhật thông tin bài trắc nghiệm !")) {
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
