import common.Assertion;
import framework.amazon.feature.SearchFeature;
import intializers.TestInit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import propertyManagement.TestCasesProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;

public class SearchProductTest extends TestInit {

    SearchFeature searchFeature = new SearchFeature();

    @Test
    private void test_001() {
        ExtentManager.startTestFromProperty(pNode, TestCasesProperties.getTestCase("TC001"));
        System.out.println("THREAD 1 : "+Thread.currentThread().getId());
        searchFeature.searchItem1("cooler");
        Assertion.verifyEqual("cooler","cooler");
    }

    @Test(dependsOnMethods = { "test_001" })
    private void test_002() {
        ExtentManager.startTestFromProperty(pNode, TestCasesProperties.getTestCase("TC002"));
        System.out.println("THREAD 2 : "+Thread.currentThread().getId());
        searchFeature.searchItem2("TV");
        Assertion.verifyEqual("TV","TV");
    }

    @Test
    @Parameters("sampleParamName")
    private void test_003(String paramValue) {
        ExtentManager.startTestFromProperty(pNode, TestCasesProperties.getTestCase("TC002"));
        System.out.println("THREAD  : "+Thread.currentThread().getId());
        searchFeature.searchItem2(paramValue);
        Assertion.verifyEqual(paramValue,paramValue);
    }
}
