package validation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Validation_DataProvider {
	@Test(dataProvider = "getData")
	public void createResponseWithDataProvider(String createdBy,String projectName,String status,int teamSize)
	{
		PojoLibrary pObj = new PojoLibrary(createdBy, projectName, status, teamSize);
		given()
		.body(pObj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArray=new Object[2][4];
		objArray[0][0] = "akash";
		objArray[0][1] = "project_A";
		objArray[0][2] = "completed";
		objArray[0][3] = 10;

		objArray[1][0] = "vikas";
		objArray[1][1] = "project_V";
		objArray[1][2] = "completed";
		objArray[1][3] = 20;
		return objArray;
	}

}
