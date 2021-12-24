package pojo;

import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class ProjectWithoutCreatedBy {
@Test
public void create()
{
	PojoLibrary pObj = new PojoLibrary("", "unknown", "completed", 9);
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
