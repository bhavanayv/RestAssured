package validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidationUsingHamcrest {
@Test
public void validate() {
	when()
		.get("http://localhost:8084/projects")
	.then()
		.assertThat().time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.assertThat().body("[2].projectName", Matchers.equalTo("project1"))
		.log().all();
}
}
