package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;


public class Deserialization {
	@Test
	public void deerialization() throws Throwable, Throwable, Throwable {
		ObjectMapper mapper = new ObjectMapper();
		PojoLibrary pObj = mapper.readValue(new File("./JsonValue"), PojoLibrary.class);
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getProjectName());
	}
}
