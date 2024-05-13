package framework.api.request;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import common.BaseClass;
import globalConstants.RequestType;
import io.restassured.response.Response;
import propertyManagement.WebProperties;
import reportManagement.ExtentManager;

public class FetchObjects {
     static BaseClass baseClass = new BaseClass();
      public  void  fetchObjects() {
        ExtentTest node = ExtentManager.getTest();
        try {
            Response response =  baseClass.restAssuredHelper.SpecifyAndSendRequest(RequestType.Get,
                    WebProperties.getProperty("fetchObjects"),
                    "", false);
            if(response.getStatusCode() != 200){
                node.fail("Response Status Code is : "+response.getStatusCode() + "  Reason : " + response.getStatusLine());
                throw new Exception("HttpResponseException + "+ response.getStatusLine());
            }
            node.info(response.asPrettyString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
