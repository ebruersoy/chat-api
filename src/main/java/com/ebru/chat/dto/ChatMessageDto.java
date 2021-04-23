package com.ebru.chat.dto;

import com.ebru.chat.model.ChatMessage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.ZonedDateTime;


/**
 * @author Ebru Ersoy Göksal
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessageDto implements Serializable {
    @JsonProperty
    private String sender;
    @JsonProperty
    private String content;
    @JsonProperty
    private Long createdAt;

    public ChatMessageDto() {
    }

    public ChatMessageDto(String sender, String content, Long createdAt) {
        this.sender = sender;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public ChatMessage getEntity(ZonedDateTime now) {
        ChatMessage message = new ChatMessage();
        message.setCreatedAt(now);
        message.setSender(this.getSender());
        message.setContent(this.getContent());
        return message;
    }
}
