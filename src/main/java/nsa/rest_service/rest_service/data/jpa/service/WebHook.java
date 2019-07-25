package nsa.rest_service.rest_service.data.jpa.service;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class WebHook {
	private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    
    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public BaseResponse getMessage(@RequestBody String request) {
    	System.out.println(request);
        return new BaseResponse(SUCCESS_STATUS, 1);
    }

}
