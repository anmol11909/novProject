//package com.scaler.finalnovprojectmodule.controller.AIController;
//
//import com.scaler.finalnovprojectmodule.Dto.ErrorDto;
//import com.scaler.finalnovprojectmodule.models.geminiModel.ChatRequest;
//import com.scaler.finalnovprojectmodule.models.geminiModel.ChatResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//public class OpenAIController {
//
//    @RestController
//    public class openAIService
//
//    public openAIController(OpenAIService openAIService) {
//        this.openAIService = openAIService;
//    }
//
//    @GetMapping("chat")
//    public ResponseEntity<ChatResponse> chat(@RequestParam String prompt) {
//        System.out.println("Api Started " + prompt);
//        ChatResponse chatResponse = new ChatResponse();
//        chatResponse = openAIService.chatService(prompt);
//
//        System.out.println("Api call ended");
//
//        return new ResponseEntity<>(chatResponse, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(OpenaiPlanExpireException.class)
//    public ErrorDto openaiplanExpireExceptionHandler(Exception e){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(e.getMessage());
//        return errorDto;
//    }
//}
