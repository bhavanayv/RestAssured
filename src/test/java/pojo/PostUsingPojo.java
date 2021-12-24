package pojo;

import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class PostUsingPojo {
@Test
public void createProject()
{
	PojoLibrary pObj=new PojoLibrary("Rohini.P", "TargetSbiPO", "On Going", 1);
	given()
		.body(pObj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
}
}
