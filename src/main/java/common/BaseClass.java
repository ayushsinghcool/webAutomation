package common;

import api.helpers.JsonProcessing;
import api.helpers.RestAssuredHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import propertyManagement.ApiProperties;

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
        RestAssured.baseURI = ApiProperties.getProperty("base.uri");
    }

    ObjectMapper obj = new ObjectMapper();

    public String convertToJson(Object ob) {
        try {
            return obj.writeValueAsString(ob);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
