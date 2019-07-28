package nsa.rest_service.rest_service.data.jpa.service;

import java.io.IOException;

import org.springframework.web.bind.annotation.*;
import nsa.chatbot.WorkWithMessages;



@RestController
@RequestMapping("/")
public class WebHook {
	private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    
    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public void getMessage(@RequestBody String request) throws IOException {
    	WorkWithMessages jsonInfo = new WorkWithMessages();
    	jsonInfo.readJson(request);
        
    }

}
