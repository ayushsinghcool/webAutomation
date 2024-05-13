import framework.api.request.FetchObjects;
import intializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCasesProperties;
import reportManagement.ExtentManager;

public class FetchObjectTest extends TestInit {

    FetchObjects fetchObjects = new FetchObjects();

    @Test
    public void test001(){
        ExtentManager.startTestFromProperty(pNode, TestCasesProperties.getTestCase("TC003"));
        fetchObjects.fetchObjects();
    }
}
