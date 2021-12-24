package CRUD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class deleteResourceTest {
@Test
public void delresource() {
	Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1402");
	ValidatableResponse validate = response.then();
	validate.statusCode(204);
	validate.log().all();
}
}
