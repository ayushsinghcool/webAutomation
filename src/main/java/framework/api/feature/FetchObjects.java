package framework.api.feature;

import com.aventstack.extentreports.ExtentTest;
import common.BaseClass;
import framework.api.request.LoginRequest;
import framework.api.response.LoginResponse;
import globalConstants.RequestType;
import io.restassured.response.Response;
import propertyManagement.ApiProperties;
import reportManagement.ExtentManager;

public class FetchObjects {
     static BaseClass baseClass = new BaseClass();
     Response response;

      public  Response  fetchObjects(LoginRequest loginRequest) {
        ExtentTest node = ExtentManager.getTest();
        try {

             response =  baseClass.restAssuredHelper.SpecifyAndSendRequest(RequestType.Get,
                     ApiProperties.getProperty("fetchObjects"),
                     baseClass.convertToJson(loginRequest),
                     false);

           // response.as(LoginResponse.class);

            node.info("Response : "+response.asPrettyString());

        } catch (Exception e) {
            node.fail("Test Case Failed");
            node.info(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

}
