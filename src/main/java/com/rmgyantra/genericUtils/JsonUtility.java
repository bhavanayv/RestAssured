package com.rmgyantra.genericUtils;
import io.restassured.response.Response;

/**
 * this method will return the value from the response based on the json path passed
 * @author Bhavana
 *
 */
public class JsonUtility {	

	public String getJsonResponseValue(Response response, String jsonpath) {
		String responseJsonvalue = response.jsonPath().get(jsonpath);
		return responseJsonvalue;
	}
}
