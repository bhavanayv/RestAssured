package CRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getAllResourcesTest {
	@Test
	public void getAllResources()
	{
		Response resp = RestAssured.get("http://localhost:8084/projects");
		System.out.println(resp.getContentType());
		System.out.println(resp.getTime());
		System.out.println(resp.getStatusCode());
		
		resp.then().log().all();
		
	}
}
