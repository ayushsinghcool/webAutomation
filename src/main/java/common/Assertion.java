package common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import intializers.WebPageInit;
import reportManagement.ExtentManager;
import utils.CommonUtils;

import static utils.CommonUtils.captureScreenWeb;

public class Assertion extends WebPageInit {
    private static ExtentTest testNode;
    private static Markup m;

    private static void createAssertionLabel(){
        m = MarkupHelper.createLabel("Assertion Block", ExtentColor.GREEN);
        ExtentManager.getTest().info(m);
    }

    private static void createCodeBlock(String actual,String expected){
        String code = "Actual   :" +actual + "\nExpected :"+expected;
        Markup m = MarkupHelper.createCodeBlock(code);
        testNode.info(m);
    }

    public static void verifyEqual(String actual,String expected){
        createAssertionLabel();
        testNode = ExtentManager.getTest();
        createCodeBlock(actual,expected);
        if(actual.equalsIgnoreCase(expected)){
            testNode.pass(m);
        }else {
            testNode.fail(m);
        }
       captureScreenWeb(testNode,"Capturing Screen");
    }

    public static void verifyContains(String actual,String expected){
        createAssertionLabel();
        testNode = ExtentManager.getTest();
        createCodeBlock(actual,expected);
        if(actual.contains(expected)){
            testNode.pass("Assertion PASS");
        }else {
            testNode.fail("Assertion FAIL");
        }
        captureScreenWeb(testNode,"");
    }
}
