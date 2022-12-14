package testcase.Setting.OKRs_CFRsTest;

import org.openqa.selenium.WebDriver;

import page.index;
import page.Setting.OKRs_CFRsPage.RaisePage;
import page.Setting.OKRs_CFRsPage.cyclePage;
import page.Setting.OKRs_CFRsPage.editRaisePage;
import setupbase.baseSetup;

public class editRaiseTest {
    public static void main(String[] args) {
        try {
            baseSetup init = new baseSetup();
            WebDriver driver = init.initChromeDriver();
            index using = new index(driver);
            cyclePage cycle = new cyclePage(driver);
            RaisePage raise = new RaisePage(driver);
            editRaisePage edit = new editRaisePage(driver);

            using.openCorp();
            using.navigation();
            Thread.sleep(1000);
            cycle.navigation_OKRs_CFRs();
            using.waitForPageLoaded();

            raise.navigatoRaise();
            Thread.sleep(1000);
            edit.click_edit();
            Thread.sleep(1000);

            edit.cleartxt();
            raise.save_btn.click();
            String noti = using.messgaeError_tagline();
            System.out.println("=========================");
            System.out.println("Testcase: 1");
            if (noti != null) {
                System.out.println(noti);
                using.passed();
                edit.sendkeytxt();
                raise.save_btn.click();
                System.out.println("=========================");
                System.out.println("Testcase: 2");
                Thread.sleep(1000);
                if (raise.verifyText()) {
                    System.out.println("Cập nhật thành công");
                    using.passed();
                } else {
                    using.failed();
                }
            } else {
                using.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
