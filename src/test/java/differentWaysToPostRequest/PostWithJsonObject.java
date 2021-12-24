package differentWaysToPostRequest;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostWithJsonObject {
@Test
public void postwithJsonObj() {
	Random random = new Random();
	int random_num=random.nextInt(400);
	JSONObject jObj = new JSONObject();
	jObj.put("createdBy", "yvb");
	jObj.put("projectName", "PGSB_"+random_num);
	jObj.put("status", "completed");
	jObj.put("teamSize", 40);
	
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
