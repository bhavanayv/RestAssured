package CRUD_with_BDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getAllResources {
@Test
public void allProjects() {
	when()
			.get("http://localhost:8084/projects")
	.then()
			.assertThat().statusCode(200)
			.and()
			.contentType(ContentType.JSON)
			.log().all();
}
}
