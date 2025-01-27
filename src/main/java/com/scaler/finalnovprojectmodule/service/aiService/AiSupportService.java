package com.scaler.finalnovprojectmodule.service.aiService;

import org.springframework.http.ResponseEntity;

public interface AiSupportService {
    public ResponseEntity<String> geminiSupport(String content);
}
