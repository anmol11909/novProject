package com.scaler.finalnovprojectmodule.models.geminiModel;

import com.mysql.cj.protocol.Message;

import java.awt.*;
import java.util.List;

public class ChatResponse {

    private List<Message> returnMessages;
    public List<Message> getReturnMessages() {
        return returnMessages;
    }

    public void setReturnMessages(List<Message> returnMessages) {
        this.returnMessages = returnMessages;
    }

}
