package com.scaler.finalnovprojectmodule.controller.AIController;

import com.scaler.finalnovprojectmodule.service.aiService.GeminiAiSupportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeminiController {
    GeminiAiSupportService geminiAiSupportService;
    public GeminiController() {
        this.geminiAiSupportService = new GeminiAiSupportService();
    }

    @PostMapping("geminisupport")
    public ResponseEntity<String> geminiChat(@RequestBody String query){
        return geminiAiSupportService.geminiSupport(query);
    }
}
