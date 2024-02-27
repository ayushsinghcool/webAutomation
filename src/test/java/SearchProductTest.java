import common.Assertion;
import framework.amazon.feature.SearchFeature;
import intializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCasesProperties;
import reportManagement.ExtentManager;

public class SearchProductTest extends TestInit {

    SearchFeature searchFeature = new SearchFeature();

    @Test
    private void test_001() {
        ExtentManager.startTestFromProperty(pNode, TestCasesProperties.getTestCase("TC001"));
        searchFeature.searchItem("cooler");
        Assertion.verifyEqual("cooler","cooler");
    }
}
