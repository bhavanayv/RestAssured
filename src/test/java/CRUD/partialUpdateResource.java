package CRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class partialUpdateResource {
@Test
public void partialUpdate()
{
	JSONObject jObj = new JSONObject();
	jObj.put("status", "completed");
	RequestSpecification reqSpec = RestAssured.given();
	reqSpec.body(jObj);
	reqSpec.contentType(ContentType.JSON);
	
	Response response = reqSpec.patch("http://localhost:8084/projects/TY_PROJ_1402");
	ValidatableResponse validate = response.then();
	System.out.println(response.getTime());
	//validate.statusCode(200);
	validate.assertThat().contentType(ContentType.JSON);
	validate.log().all();
}
}
