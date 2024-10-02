package api.helpers;

import com.aventstack.extentreports.ExtentTest;
import globalConstants.RequestType;
import globalConstant.RestAssuredConstants;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import propertyManagement.ApiProperties;
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
		//resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resBuilder.build();
		request = RestAssured.given();

		try {
			if (auth) {

				request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson, "Authorization", RestAssuredConstants.auth);
				node.info("Headers : " + RestAssuredConstants.ContentType + " " + RestAssuredConstants.ApplicationJson + " " + "Authorization : " + RestAssuredConstants.auth);

			} else {

				request.headers(RestAssuredConstants.ContentType, RestAssuredConstants.ApplicationJson);
				node.info("Headers : " + RestAssuredConstants.ContentType + " " + RestAssuredConstants.ApplicationJson);

			}
			if (postModelAsString != null) {
				node.info("Request : "+ postModelAsString);

			}
			switch (requestType) {
				case Delete:
					response = request.delete(url);
					node.info("Request Type : DELETE");
					node.info("URL : " + ApiProperties.getProperty("base.uri") + url);
					break;
				case Get:
					node.info("Request Type : GET");
					node.info("URL : " + ApiProperties.getProperty("base.uri") + url);
					response = request.get(url);
					break;
				case Patch:
					response = request.patch(url);
						node.info("Request Type : PATCH");
						node.info("URL : " + ApiProperties.getProperty("base.uri") + url);
					break;
				case Post:
					response = request.post(url);
						node.info("Request Type : POST");
						node.info("URL : " + ApiProperties.getProperty("base.uri") + url);
					break;
				case Put:
					response = request.put(url);
						node.info("Request Type : PUT");
						node.info("URL : " + ApiProperties.getProperty("base.uri") + url);
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
