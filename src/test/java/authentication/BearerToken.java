package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class BearerToken {
@Test
public void token() {
	given()
		.auth().oauth2("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")
	.when()
		.get("https://api.github.com/user/repos")
	.then()
		.log().all();
}
}
