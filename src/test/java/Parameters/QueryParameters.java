package Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParameters {
@Test
public void queryAndPath() {
	given()
			.pathParam("username", "bhavanayv")
			.queryParam("sort", "updated")
	.when()
			.get("http://api.github.com/users/{username}/repos")
	.then()
			.statusCode(200)
			.log().all();
}
}
