package olu.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.bytebuddy.asm.Advice.Return;




public class datsReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
		String JsonContent = FileUtils.readFileToString(new File ("C:\\Users\\New Owner\\eclipse-workspace\\SeleniumFrameworks\\src\\test\\java\\olu\\data\\purchase.json"),  
				StandardCharsets.UTF_8);
	
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
    });
	return data;
}
	
}

