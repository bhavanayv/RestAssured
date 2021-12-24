package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.rmgyantra.pojoLib.PojoLibrary;

public class Serialization {
	@Test
	public void serialization() throws Throwable, Throwable, Throwable {
		PojoLibrary pObj=new PojoLibrary("Bhavana TYSS", "TestYantra", "completed", 4);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./JsonValue"), pObj);
	}
}
