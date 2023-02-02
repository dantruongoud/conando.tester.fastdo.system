package testcase.Educate.qiz;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
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
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Sửa bài trắc nghiệm");

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
                Thread.sleep(1000);

                for (int i = 1; i < 9; i++) {
                    System.out.println("=========================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    qiz.clearDataTest();

                    qiz.create_qiz(excel.getCellData("title", i), excel.getCellData("time", i),
                            excel.getCellData("point", i), excel.getCellData("content", i),
                            excel.getCellData("result", i));
                    Thread.sleep(1000);
                    index.btnComponent.click();

                    Boolean passed = false;
                    String noti = index.messgaeError_tagline();
                    for (int j = 0; j < qiz.tagline.length; j++) {
                        if (noti.equals(qiz.tagline[j])) {
                            passed = true;
                            index.passed();
                            // Khi sửa thì trường hợp này luôn luôn đúng nên k cần check
                            // if (j == 5)
                            // qiz.checkbox_check.click();
                            break;
                        } else if (noti.equals(qiz.tagline[6])) {
                            passed = true;
                            index.passed();
                            break;
                        }
                    }
                    if (!passed) {
                        index.failed();
                    }
                    // switch (noti) {
                    // case "Nhập tiêu đề và thời lượng bài trắc nghiệm !":
                    // System.out.println(noti);
                    // qiz.print();
                    // break;
                    // case "Giá trị mức điểm đạt phải lớn hơn hoặc bằng 1 !":
                    // System.out.println(noti);
                    // qiz.print();
                    // break;
                    // case "Mức điểm đạt được của bài thi phải nhỏ hơn tổng điểm bài thi !":
                    // System.out.println(noti);
                    // qiz.print();
                    // break;
                    // case "Có câu hỏi chưa nhập nội dung, vui lòng nhập nội dung cho câu hỏi":
                    // System.out.println(noti);
                    // qiz.print();
                    // break;
                    // case "Có đáp án chưa có nội dung, vui lòng nhập nội dung cho đáp án !":
                    // System.out.println(noti);
                    // qiz.print();
                    // break;
                    // // Khi sửa thì trường hợp này luôn luôn đúng nên k cần check
                    // // case "Có câu hỏi chưa có đáp án đúng, vui lòng chọn 1 đáp án đúng cho câu
                    // hỏi
                    // // !":
                    // // System.out.println(noti);
                    // // qiz.check_checkbox();
                    // // qiz.print();
                    // // break;
                    // default:

                    // noti = index.messgaeError_tagline();
                    // if (noti.equals("Đã cập nhật thông tin bài trắc nghiệm !")) {
                    // System.out.println(noti);
                    // index.passed();
                    // } else {
                    // System.out.println(noti);
                    // index.failed();
                    // }
                    // break;
                    // }

                    // Thread.sleep(1200);
                }
            } else {
                index.error_titlePage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
