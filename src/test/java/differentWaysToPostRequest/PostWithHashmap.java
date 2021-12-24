package differentWaysToPostRequest;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostWithHashmap {
@Test
public void create()
{
	Random random = new Random();
	int random_num = random.nextInt();
	HashMap hsObj = new HashMap();
	hsObj.put("createdBy", "karthik");
	hsObj.put("projectName", "PROJECT_"+random_num);
	hsObj.put("status", "completed");
	hsObj.put("teamSize", "14");
	
	given()
			.body(hsObj)
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