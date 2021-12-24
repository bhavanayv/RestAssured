package testCases;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.rmgyantra.genericUtils.EndPoints;
import com.rmgyantra.genericUtils.JavaUtility;
import com.rmgyantra.pojoLib.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateAndDeleteUserTest {
	@Test
	public void createAndDeleteUserTest() {
		JavaUtility jUtil=new JavaUtility();
		String expectedProjectName="TEAM B_"+jUtil.random();
		String expectedUserName="DELTA_"+jUtil.random();

		PojoLibrary pObj=new PojoLibrary("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657", expectedProjectName, "ROLE_ADMIN", expectedUserName);
		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)
				.when()
				.post(EndPoints.CREATEUSER);

		String responseUserID=response.jsonPath().get("employeeId");

		response.then()
		.assertThat().statusCode(201)
		.and()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(6000L),TimeUnit.MILLISECONDS)
		.log().all();
/*
		given()
		.pathParam("empId", responseUserID)
		.when()
		.delete(EndPoints.DELETEUSER)
		.then()
		.assertThat().statusCode(204).and().log().all();


*/

	}
}
