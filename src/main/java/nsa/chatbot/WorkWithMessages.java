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
	
	//public static String stoken = "wRykpqkYXo0EvYqGTVaESoVcABmSZEi4PBjZ8hyOzQk";
		
	public static void readJson(String request) throws IOException, ClientException, APIException {
		String chatToken = "wRykpqkYXo0EvYqGTVaESoVcABmSZEi4PBjZ8hyOzQk";
		ObjectMapper mapper = new ObjectMapper();
		try {
        JsonNode rootNode = mapper.readValue(request, JsonNode.class);
        JsonNode childNodeText = rootNode.get("message").get("body").get("text");
        JsonNode childNodeUserId = rootNode.get("message").get("sender").get("user_id");
        
        long user_id = childNodeUserId.asLong();
        
        String message = childNodeText.asText();
        System.out.println("---------------------------------");
        System.out.println(message);
        String answerMessage = "Auto answer --> "+message;
        sendAnswer(chatToken, user_id, answerMessage);
			} catch (IOException e) {
				System.out.println(e.getMessage());	
			}
		}
	
	public static void sendAnswer(String chatToken, long user_id, String messageToUser) throws ClientException, APIException {
		//String mid = "mid.0000000c7282027a016c374712671b7f";
		//long seq = 102517669913631615;
		List<AttachmentRequest> attach = null;
		NewMessageLink link = null;
		
		TamTamBotAPI api = TamTamBotAPI.create(chatToken);
		NewMessageBody body = new NewMessageBody(messageToUser, attach, link);
		SendMessageQuery sendMessageQuery = api.sendMessage(body).userId(user_id);
		SendMessageResult result = sendMessageQuery.execute();
	}

}
