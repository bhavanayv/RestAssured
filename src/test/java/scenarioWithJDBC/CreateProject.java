package scenarioWithJDBC;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.pojoLib.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateProject {
	@Test
	public void createProj() throws SQLException {
		Random ranNum = new Random();
		int random_num=ranNum.nextInt(400);
		PojoLibrary pObj = new PojoLibrary("TJV", "TYSS"+random_num, "completed", 6);
		//PojoLibrary pObj = new PojoLibrary("TJV", "TYSS_844", "completed", 6);
		Response response = given()
				.body(pObj)
				.contentType(ContentType.JSON)
				.when()
				.post("http://localhost:8084/addProject");

		String actualprojName=response.jsonPath().get("projectName");
		String actualProjId=response.jsonPath().get("projectId");

		System.out.println(actualprojName);
		System.out.println(actualProjId);

		response.then()
		.assertThat().statusCode(201)
		.and()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000L), TimeUnit.MILLISECONDS)
		.log().all();

		Driver driver_ref=new Driver();
		DriverManager.registerDriver(driver_ref);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("select project_name from project where project_id='"+actualProjId+"';");
		String expected=null;
		while(set.next())
		{
			expected = set.getString(1);
			System.out.println(expected);

		}
		Assert.assertEquals(expected,actualprojName);
		connection.close();
	}
}
