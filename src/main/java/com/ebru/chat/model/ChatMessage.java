package com.ebru.chat.model;

import java.time.LocalDateTime;

/**
 * @author Ebru Ersoy Göksal
 */
public class ChatMessage {
    private String content;
    private String sender;
    private String timestamp;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
