package chatbot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class Messages {
	
	public static void readJson(String request) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readValue(request, JsonNode.class);
        String message = rootNode.get("sender").asText();
        System.out.println("---------------------------------");
        System.out.println(message);
	}

}
