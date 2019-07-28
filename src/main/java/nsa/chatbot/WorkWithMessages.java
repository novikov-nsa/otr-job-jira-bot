package nsa.chatbot;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import chat.tamtam.botapi.TamTamBotAPI;
import chat.tamtam.botapi.exceptions.APIException;
import chat.tamtam.botapi.exceptions.ClientException;
import chat.tamtam.botapi.model.Attachment;
import chat.tamtam.botapi.model.AttachmentRequest;
import chat.tamtam.botapi.model.MessageBody;
import chat.tamtam.botapi.model.NewMessageBody;
import chat.tamtam.botapi.model.NewMessageLink;
import chat.tamtam.botapi.model.SendMessageResult;
import chat.tamtam.botapi.queries.SendMessageQuery;

import java.io.IOException;
import java.util.List;

public class WorkWithMessages {
	
	public WorkWithMessages() {
		
		
		
	}
	
	public static String stoken = "wRykpqkYXo0EvYqGTVaESoVcABmSZEi4PBjZ8hyOzQk";
		
	public static void readJson(String request) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		try {
        JsonNode rootNode = mapper.readValue(request, JsonNode.class);
        JsonNode childNodeMessage =  rootNode.get("message");
        JsonNode childNodeBody =  childNodeMessage.get("body");
        JsonNode childNodeText = childNodeBody.get("text");
        
        String message = childNodeText.asText();
        System.out.println("---------------------------------");
        System.out.println(message);
			} catch (IOException e) {
				System.out.println(e.getMessage());	
			}
		}
	
	public static void sendAnswer(String messageToUser) throws ClientException, APIException {
		//String mid = "mid.0000000c7282027a016c374712671b7f";
		//long seq = 102517669913631615;
		List<AttachmentRequest> attach = null;
		long userId = 573535126362;
		NewMessageLink link = null;
		
		TamTamBotAPI api = TamTamBotAPI.create(stoken);
		NewMessageBody body = new NewMessageBody("hello world!", attach, link);
		SendMessageQuery sendMessageQuery = api.sendMessage(body).userId(userId);
		SendMessageResult result = sendMessageQuery.execute();
	}

}
