package common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class Assertion {
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
    }

    public static void assertAPI(String actual,String expected){
        testNode = ExtentManager.getTest();
        try {
            createAssertionLabel();
            createCodeBlock(actual, expected);
            if (actual.equalsIgnoreCase(expected)) {
                testNode.pass(m);
            } else {
                testNode.fail(m);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            testNode.fail("Test Case Failed");
            testNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
