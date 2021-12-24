package requestChaining;

import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateProjectAndDelete {
@Test
public void postAndDelete()
{
	PojoLibrary pObj=new PojoLibrary("BHAVANA", "RMGYANTRA", "completed", 10);
	Response response = given().body(pObj).contentType(ContentType.JSON).post("http://localhost:8084/addProject");			
	String projId = response.jsonPath().get("projectId");
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
