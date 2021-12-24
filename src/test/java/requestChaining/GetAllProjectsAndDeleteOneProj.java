package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetAllProjectsAndDeleteOneProj {
@Test
public void getAndDelete()
{
	Response response = when().get("http://localhost:8084/projects");
	String projId=response.jsonPath().get("[2].projectId");
	System.out.println(projId);
	given()
			.pathParam("projectID", projId)
	.when()
			.delete("http://localhost:8084/projects/{projectID}")
	.then()
			.assertThat().statusCode(204)
			.log().all();
}
}
