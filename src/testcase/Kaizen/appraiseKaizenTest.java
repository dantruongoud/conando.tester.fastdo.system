package testcase.Kaizen;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Kaizen.CreateKaizenPage;
import page.Kaizen.appraiseKaizenPage;
import setupbase.baseSetup;

public class appraiseKaizenTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index index = new index(driver);
            CreateKaizenPage kaizen = new CreateKaizenPage(driver);
            appraiseKaizenPage appraise = new appraiseKaizenPage(driver);

            index.openCorp();

            kaizen.navigation_Kaizen();
            index.waitForPageLoaded();

            appraise.chose_Kaizen("Tôi cần góp ý");
            index.waitForPageLoaded();

            if (index.verifyTitle("Chi tiết Kaizen")) {
                appraise.chose_menu();
                Thread.sleep(1000);
                appraise.chose_submenu();
                Thread.sleep(1000);
                appraise.chose_criteria();
                Thread.sleep(1000);
                appraise.click_save();
                System.out.println("Đánh giá thành công");
                index.passed();
                appraise.verify_appraise();
            } else {
                index.error_titlePage();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
