package pojo;

import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class ModifyProject {
@Test
public void modifyProject()
{
	PojoLibrary pObj = new PojoLibrary("xyz", "projectxyz", "created", 10);
	given()
		.body(pObj)
		.contentType(ContentType.JSON)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_2006")
	.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
}
}
