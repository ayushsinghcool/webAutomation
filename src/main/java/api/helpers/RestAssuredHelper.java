package api.helpers;

import com.aventstack.extentreports.ExtentTest;
import globalConstants.RequestType;
import globalConstant.RestAssuredConstants;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import propertyManagement.ExecutionProperties;
import reportManagement.ExtentManager;


import static globalConstant.NumberConstants.MAX_TIMEOUT;

public class RestAssuredHelper   {
	public static String logs;
	protected  ResponseSpecBuilder resBuilder;
	protected RequestSpecification request;
	protected Response response = null;

	
	public Response SpecifyAndSendRequest(RequestType requestType, String url, String postModelAsString, boolean auth) {
		ExtentTest node = ExtentManager.getTest();
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		/*authScheme.setUserName("Admin");
		authScheme.setPassword("secret");
		RestAssured.authentication = authScheme;*/
		RestAssured.responseSpecification = resBuilder.build();
		request = RestAssured.given();

		try {
			if (auth) {
				request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson, "Authorization", RestAssuredConstants.auth);
				System.out.println(RestAssuredConstants.auth);
				node.info("Headers : " + RestAssuredConstants.ContentType + " " + RestAssuredConstants.ApplicationJson + " " + "Authorization : " + RestAssuredConstants.auth);
			} else {
				//request.auth().preemptive().basic(ExecutionProperties.getProperty("username"),ExecutionProperties.getProperty("password"));
				request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson,"skipSecurityHeaderValidation","true");
				node.info("Headers : " + RestAssuredConstants.ContentType + " " + RestAssuredConstants.ApplicationJson);
			}
			//request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson, "Authorization", "Bearer mnmtrlv4e9vj5b115fcftrohpvcnbyfm");
			if (postModelAsString != null) {
				request.body(postModelAsString);
			}
			switch (requestType) {
				case Delete:
					response = request.delete(url);
					//node.info("Request Type : DELETE");
					//node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				case Get:
					node.info("Request Type : GET");
					node.info("URL : " + "https://dwdev1.qnb.com/extensibility/v1" + url);
					response = request.get(url);
					break;
				case Patch:
					response = request.patch(url);
					//	node.info("Request Type : PATCH");
					//	node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				case Post:
					response = request.post(url);
					//	node.info("Request Type : POST");
					//	node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				case Put:
					response = request.put(url);
					//	node.info("Request Type : PUT");
					//	node.info("URL : "+"https://psmw.gpay.digital/dev_mobiq_api"+url);
					break;
				default:
					throw new UnsupportedOperationException("Request type is not supported.");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return response;
	}

}
