package CRUD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class updateResourceTest {
@Test
public void updateresource()
{
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "siri");
	jObj.put("projectName", "RMG");
	jObj.put("status", "siri");
	jObj.put("teamSize", 2);
	
	RequestSpecification reqSpec = RestAssured.given();
	reqSpec.body(jObj);
	reqSpec.contentType(ContentType.JSON);
	Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1402");
	ValidatableResponse validate = response.then();
	System.out.println(response.getTime());
	validate.statusCode(200);
	validate.assertThat().contentType(ContentType.JSON);
	validate.log().all();
}
}
