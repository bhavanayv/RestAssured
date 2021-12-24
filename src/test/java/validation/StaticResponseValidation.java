package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
@Test
public void staticResponse()
{
	String expectedProjId="TY_PROJ_001";
	Response response = when().get("http://localhost:8084/projects");
	String actualProjId = response.jsonPath().get("[0].projectId");
	response.then().assertThat().log().all();
	
	Assert.assertEquals(actualProjId, expectedProjId);
}
}