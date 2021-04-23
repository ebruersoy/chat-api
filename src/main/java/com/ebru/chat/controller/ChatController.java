package com.ebru.chat.controller;

import com.ebru.chat.dto.ChatMessageDto;
import com.ebru.chat.exception.InvalidRequestException;
import com.ebru.chat.service.ChatService;
import com.ebru.chat.utils.Util;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Ebru Ersoy Göksal
 */
@RestController
@RequestMapping(path = "api/v1")
public class ChatController {

    ChatService chatService;
    SimpMessagingTemplate template;

    public ChatController(ChatService chatService, SimpMessagingTemplate template) {
        this.chatService = chatService;
        this.template = template;
    }

    @GetMapping("messages")
    public List<ChatMessageDto> getMessages() {
        return chatService.getMessages();
    }

    @PostMapping("send")
    public void sendMessage(@RequestBody ChatMessageDto messageRequest) {
        if(messageRequest.getContent() == null || messageRequest.getContent().isEmpty()){
            throw new InvalidRequestException("content", messageRequest.getContent(),"not null or empty");
        }
        if(messageRequest.getSender() == null || messageRequest.getSender().isEmpty()){
            throw new InvalidRequestException("sender", messageRequest.getSender(),"not null or empty");
        }
        ZonedDateTime now = ZonedDateTime.now();
        messageRequest.setCreatedAt(Util.toEpochMilliSeconds(now));
        template.convertAndSend("/topic/public", messageRequest);
        chatService.saveMessage(messageRequest.getEntity(now));
    }


}
