package com.ebru.chat.dto;

import com.ebru.chat.model.ChatMessage;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;


/**
 * @author Ebru Ersoy Göksal
 */

public class ChatMessageDto implements Serializable {
    @JsonProperty(required = true )
    @NotNull(message = "Sender is mandatory")
    @NotEmpty(message = "Sender is mandatory")
    private String sender;

    @JsonProperty(required = true)
    @NotNull(message = "Content is mandatory")
    @NotEmpty(message = "Content is mandatory")
    private String content;

    @JsonProperty
    private Long createdAt;

    public ChatMessageDto() {
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
