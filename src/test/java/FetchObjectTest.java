import common.Assertion;
import framework.api.feature.FetchObjects;
import framework.api.request.LoginRequest;
import intializers.TestInit;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import propertyManagement.ApiProperties;
import propertyManagement.TestCasesProperties;
import reportManagement.ExtentManager;

public class FetchObjectTest extends TestInit {

    LoginRequest loginRequest;
    FetchObjects fetchObjects;
    Response response;

    @BeforeClass
    public void setup(){
        loginRequest = new LoginRequest();
        fetchObjects = new FetchObjects();
        loginRequest.setUsername("ayush");
        loginRequest.setPassword("ayush");
    }

    @Test
    public void test001(){

        ExtentManager.startTestFromProperty(pNode, TestCasesProperties.getTestCase("TC001"));
        response = fetchObjects.fetchObjects(loginRequest);

        Assertion.assertAPI(String.valueOf(response.getStatusCode()),"200");
        Assertion.assertAPI(response.path("name").toString(),"[Google Pixel 6 Pro, Apple iPhone 12 Mini, 256GB, Blue, Apple iPhone 12 Pro Max, Apple iPhone 11, 64GB, Samsung Galaxy Z Fold2, Apple AirPods, Apple MacBook Pro 16, Apple Watch Series 8, Beats Studio3 Wireless, Apple iPad Mini 5th Gen, Apple iPad Mini 5th Gen, Apple iPad Air, Apple iPad Air]");

    }
}
