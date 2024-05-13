package common;

import api.helpers.JsonProcessing;
import api.helpers.RestAssuredHelper;
import com.aventstack.extentreports.ExtentTest;
import globalConstants.StatusCodeConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import propertyManagement.WebProperties;
import reportManagement.ExtentManager;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class BaseClass {
    JsonProcessing data;
    public RestAssuredHelper restAssuredHelper;
    public BaseClass()
    {
        SetBaseUri();
        data = new JsonProcessing();
        restAssuredHelper = new RestAssuredHelper();
    }
    public void SetBaseUri()
    {
        RestAssured.baseURI = WebProperties.getProperty("base.uri");
    }

    public void AssertStatusCode(Response response, String txnStatus)
    {
        ExtentTest node = ExtentManager.getTest();
        int actualStatusCode = response.getStatusCode();
        node.info("Response Code :"+actualStatusCode);
        String actualResponseBody=response.body().prettyPrint();
        node.info("Response Body :"+actualResponseBody);
        System.out.println("Response Status Code: " + actualStatusCode);
        System.out.println("Response Status Body: " + actualResponseBody);
        Assertion.assertAPI(String.valueOf(actualStatusCode), String.valueOf(StatusCodeConstants.Ok));
        Assertion.assertAPI(txnStatus, "PENDING");
    }

    public void AssertContent(Object postModel, Response response)
    {
        Map<?, ?> actualResponseBody = response.jsonPath().get();
        System.out.println("Actual Response Content:" + actualResponseBody);

        Map<?, ?> expectedResponseBody = data.ConvertModelToMap(postModel);
        System.out.println("Expected Response Content:" + expectedResponseBody);

        assertEquals(expectedResponseBody, actualResponseBody);
    }
}
