package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class oAuth_2_0 {
@Test
public void oauth_2(){
	Response response = 
			given()
			.formParam("client_id", "SDET_24")
			.formParam("client_secret", "a76b8241c60c54a39d03bddee664e776")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
	.when()
			.post("http://coop.apps.symfonycasts.com/token");
//	.then().log().all();
	String token=response.jsonPath().get("access_token");
	System.out.println(token);
	
	given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2541)
	.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
	.then()
			.log().all();
}
}
