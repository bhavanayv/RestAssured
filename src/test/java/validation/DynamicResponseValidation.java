package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	@Test
	public void dynamicResponse()
	{
		String expectedProjId="TY_PROJ_004";
		Response response = when().get("http://localhost:8084/projects");
		List<String> allProjId = response.jsonPath().get("projectId");
		//String verify = null;
		boolean flag=false;
		for(String projId:allProjId)
		{
			if(projId.equals(expectedProjId))
			{
				flag=true;
			}
		}
		Assert.assertEquals(flag, true);	
	}
}
