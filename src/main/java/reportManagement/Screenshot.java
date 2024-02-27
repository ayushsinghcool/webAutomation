package reportManagement;

import common.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DateUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    private static WebDriver webdriver;

    static {
           webdriver = DriverFactory.getDriver();
    }
    public static String captureScreenWeb() {
        System.out.println("\n Taking Screenshot");
        String capturePath = "reports/captures/";
        String fileName = "scr" + DateUtil.getCurrentDateAndTimeForReport() + ".png";
        String filePath = capturePath + fileName;
        try {
            File src = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "../captures/"+fileName;
    }
}
