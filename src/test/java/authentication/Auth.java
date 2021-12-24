package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Auth {
	@Test
	public void prermptiveAuth() {
		given()
		.auth()
		.preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.log().all();
	}
	@Test
	public void digestiveAuth()
	{
		given()
		.auth()
		.digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.log().all();
	}
}
