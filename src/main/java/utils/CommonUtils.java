package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reportManagement.ExtentManager;


public class CommonUtils {

    private CommonUtils(){}

    private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    public static void pauseExecution(long seconds){
        try{
            logger.info("Current Thread is sleep for {} sec",seconds);
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            logger.info("Error occured");
            Thread.currentThread().interrupt();
        }
    }

    public static void createMethodLabel(String methodName){
        Markup m = MarkupHelper.createLabel("Inside Method: "+methodName, ExtentColor.TEAL);
        ExtentManager.getTest().info(m);
    }

    public static void attachFileAsExtentLog(String filename,ExtentTest node){
        node.log(Status.INFO, "<b> <h6><font color='TEAL'>Link to Log File :</b><a href='" + filename + "'><b><h6><font color='blue'> " + filename + "</font></h6></b></a>");
    }

}
