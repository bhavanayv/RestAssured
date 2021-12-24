package CRUD_with_BDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateResourceTest {
@Test
public void updateProject()
{
	Random random = new Random();
	int random_Num = random.nextInt(400);
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "Debu");
	jObj.put("projectName", "RMG"+random_Num);
	jObj.put("status", "completed");
	jObj.put("teamSize", 4);
	
	given()
			.body(jObj)
			.contentType(ContentType.JSON)
	.when()
			.put("http://localhost:8084/projects/TY_PROJ_1603")
	.then()
			.assertThat().statusCode(200)
			.and()
			.contentType(ContentType.JSON)
			.log().all();
}
}
