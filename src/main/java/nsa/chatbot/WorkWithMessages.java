package nsa.chatbot;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class WorkWithMessages {
	
		
	public static void readJson(String request) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		try {
        JsonNode rootNode = mapper.readValue(request, JsonNode.class);
        String message = rootNode.get("user_id").asText();
        System.out.println("---------------------------------");
        System.out.println(message);
			} catch (IOException e) {
				System.out.println(e.getMessage());	
			}
		}

}
