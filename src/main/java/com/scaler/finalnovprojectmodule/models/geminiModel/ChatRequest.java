package com.scaler.finalnovprojectmodule.models.geminiModel;

import com.mysql.cj.protocol.Message;

import java.util.List;

public class ChatRequest {

    private String model;
    private List<Message> messages;
    private double temperature;

    public ChatRequest(String model, List<Message> messages, double temperature) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
