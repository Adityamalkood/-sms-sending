package com.SmsService.Twilio.Payload;
public class MessageRequest {

    private String to;
    private String from;
    private String message;

    // Default constructor (required for JSON parsing)
    public MessageRequest() {
    }

    // Parameterized constructor
    public MessageRequest(String to, String message,String from) {
        this.to = to;
        this.message = message;
        this.message=from;
    }

    // Getters and setters

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
