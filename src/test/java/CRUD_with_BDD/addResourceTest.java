package CRUD_with_BDD;

import java.util.Random;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class addResourceTest {
@Test
public void addProject()
{
	Random random = new Random();
	int random_Num = random.nextInt(400);
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "YV");
	jObj.put("projectName", "RMG"+random_Num);
	jObj.put("status", "completed");
	jObj.put("teamSize", 4);
	
	given()
			.body(jObj)
			.contentType(ContentType.JSON)
	.when()
			.post("http://localhost:8084/addProject")
	.then()
			.assertThat().statusCode(201)
			.and()
			.contentType(ContentType.JSON)
			.log().all();
}
}
