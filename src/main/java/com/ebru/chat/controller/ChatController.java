package com.ebru.chat.controller;

import com.ebru.chat.dto.ChatMessageDto;
import com.ebru.chat.service.ChatService;
import com.ebru.chat.utils.Util;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Ebru Ersoy Göksal
 */
@RestController
@RequestMapping(path = "api/v1")
@Validated
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
    public void sendMessage(@Valid @RequestBody ChatMessageDto messageRequest) {
        ZonedDateTime now = ZonedDateTime.now();
        messageRequest.setCreatedAt(Util.toEpochMilliSeconds(now));
        template.convertAndSend("/topic/public", messageRequest);
        chatService.saveMessage(messageRequest.getEntity(now));
    }


}
