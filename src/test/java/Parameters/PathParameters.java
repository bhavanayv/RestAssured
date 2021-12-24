package Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParameters {
@Test
public void pathParams()
{
	String projId="TY_PROJ_1803";
	given()
			.pathParam("projectId", projId)
	.when()
			.delete("http://localhost:8084/projects/{projectId}")
	.then()
			.assertThat().statusCode(204)
			.log().all();
}
}
