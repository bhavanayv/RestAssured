package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmgyantra.genericUtils.BaseAPIclass;
import com.rmgyantra.genericUtils.EndPoints;
import com.rmgyantra.genericUtils.JavaUtility;
import com.rmgyantra.pojoLib.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectWithCompletedStatusTest extends BaseAPIclass{
	@Test
	public void createTest() throws Throwable {
		JavaUtility jUtil=new JavaUtility();
		String expectedProjectName="RMGY:"+jUtil.random();

		PojoLibrary pObj=new PojoLibrary("TEAM TY", expectedProjectName, "completed", 800);
		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)
				.when()
				.post(EndPoints.ADDPROJECT);
		String responseProjectName = response.jsonPath().get("projectName");

		response.then()
		.assertThat().statusCode(201)
		.and()
		.contentType(ContentType.JSON)
		.log().all();

		String databaseProjectName=dbUtil.getDataAndVerifyTheData("select * from project", 4, expectedProjectName);
		Assert.assertEquals(responseProjectName, databaseProjectName);
	}
}
