package testCases;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmgyantra.genericUtils.BaseAPIclass;
import com.rmgyantra.genericUtils.EndPoints;
import com.rmgyantra.genericUtils.JavaUtility;
import com.rmgyantra.pojoLib.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProjectAndAllocateUserTest extends BaseAPIclass{
@Test
public void createProjectAndAllocateUserTest() {
	
	JavaUtility jUtil=new JavaUtility();
	String expectedProjectName="TEAM A_"+jUtil.random();
	PojoLibrary pObj_project=new PojoLibrary("Deepak", expectedProjectName, "completed", 20);
	
	Response response_project = given()
			.body(pObj_project)
			.contentType(ContentType.JSON)
	.when()
			.post(EndPoints.ADDPROJECT);
	
	String responseProjectName=response_project.jsonPath().get("projectName");
	System.out.println("Project name from response body: "+responseProjectName);
	response_project.then()	
			.assertThat().statusCode(201)
			.and()
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(6000L),TimeUnit.MILLISECONDS)
			.log().all();
	
	String expectedUserName="DELTA_"+jUtil.random();
	PojoLibrary pObj_User=new PojoLibrary("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657", responseProjectName, "ROLE_ADMIN", expectedUserName);
	Response response_user = given()
			.body(pObj_User)
			.contentType(ContentType.JSON)
	.when()
			.post(EndPoints.CREATEUSER);
	
	String response_userId=response_user.jsonPath().get("employeeId");
	
	response_user.then()
			.assertThat().statusCode(201)
			.and()
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(6000L),TimeUnit.MILLISECONDS)
			.log().all();
	
//	String database_userID=dbUtil.getDataAndVerifyTheData("", DEFAULT_PORT, expectedProjectName)
}
}
