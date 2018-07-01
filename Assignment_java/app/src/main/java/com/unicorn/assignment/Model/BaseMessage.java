package com.unicorn.assignment.Model;

public class BaseMessage {
    String message;
    String sender;
    long createdAt;

    public BaseMessage(String userName, String message)
    {
        sender = userName;
        this.message = message;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}