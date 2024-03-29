package testcase.Educate.essay;

import org.openqa.selenium.WebDriver;

import excelHelpers.excelhelpers;
import page.index;
import page.Educate.createEducatePage;
import page.Educate.editEducatePage;
import page.Educate.essay.createEssayPage;
import setupbase.baseSetup;

public class createEssayTest {

    public static void main(String[] args) {
        try {

            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            createEducatePage create = new createEducatePage(driver);
            editEducatePage edit = new editEducatePage(driver);
            createEssayPage essay = new createEssayPage(driver);
            excelhelpers excel = new excelhelpers();
            excel.setExcelSheet("Bài thi tự luận");

            index.openCorp();
            create.navigation_educate();
            Thread.sleep(1000);

            create.CrudEducate();
            index.waitForPageLoaded();

            edit.choseEducate("Automation");
            Thread.sleep(1200);
            essay.navigation_essay();
            index.waitForPageLoaded();

            if (edit.verifyLesson("CHI TIẾT BÀI TỰ LUẬN")) {
                edit.addQuestion();
                Thread.sleep(1000);

                for (int i = 1; i < 8; i++) {
                    System.out.println("======================");
                    System.out.println("Testcase: " + excel.getCellData("TCID", i));
                    essay.clearDataTest();

                    essay.createEssay(excel.getCellData("Title", i), excel.getCellData("Time", i),
                            excel.getCellData("Point", i), excel.getCellData("Content", i));
                    Thread.sleep(1000);
                    index.btnComponent.click();

                    Boolean passed = false;
                    String noti = index.messgaeError_tagline();
                    for (int j = 0; j < essay.tagline.length; j++) {
                        if (noti.equals(essay.tagline[j])) {
                            passed = true;
                            index.passed();
                            break;
                        }
                    }
                    if (!passed)
                        index.failed();
                    // switch (noti) {
                    // case "Nhập tiêu đề và thời lượng bài tự luận !":
                    // System.out.println(noti);
                    // essay.print();
                    // break;
                    // case "Giá trị mức điểm đạt phải lớn hơn hoặc bằng 1 !":
                    // System.out.println(noti);
                    // essay.print();
                    // break;
                    // case "Mức điểm đạt được của bài thi phải nhỏ hơn tổng điểm bài thi !":
                    // System.out.println(noti);
                    // essay.print();
                    // break;
                    // case "Có câu hỏi chưa nhập nội dung !":
                    // System.out.println(noti);
                    // essay.print();
                    // break;
                    // default:
                    // noti = index.messgaeError_tagline();
                    // if (noti.equals("Đã cập nhật thông tin bài tự luận !")) {
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
