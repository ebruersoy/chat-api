package com.ebru.chat.utils;

import com.ebru.chat.dto.ChatMessageDto;
import com.ebru.chat.model.ChatMessage;

import java.time.ZonedDateTime;

/**
 * @author Ebru Ersoy Göksal
 */
public class Util {
    public static ChatMessageDto modelToDto(ChatMessage model){
        ChatMessageDto dto = new ChatMessageDto();
        dto.setSender( model.getSender());
        dto.setContent(model.getContent());
        dto.setCreatedAt(toEpochMilliSeconds(model.getCreatedAt()));
        return dto;
    }

    public static Long toEpochMilliSeconds(ZonedDateTime dateTime){
        return dateTime.toEpochSecond() * 1000;
    }
}
