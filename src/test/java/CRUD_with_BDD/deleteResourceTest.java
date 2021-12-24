package CRUD_with_BDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class deleteResourceTest {
@Test
public void deleteProject() {
	when()
			.delete("http://localhost:8084/projects/TY_PROJ_1603")
	.then()
			.assertThat().statusCode(204)
			.log().all();
}
}
