package CRUD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class createResourceTest {
	
	@Test
public void createresource() {
	Random ranNum = new Random();
	int random_num=ranNum.nextInt(400);
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "bhavs");
	jObj.put("projectName", "proj_"+random_num);
	jObj.put("status", "completed");
	jObj.put("teamSize", 10);
	
	RequestSpecification respSpec = RestAssured.given();
	respSpec.body(jObj);
	respSpec.contentType(ContentType.JSON);
	Response response = respSpec.post("http://localhost:8084/addProject");
	
	ValidatableResponse validate = response.then();
	validate.statusCode(201);
	validate.assertThat().contentType(ContentType.JSON);
	validate.log().all();
}
}
