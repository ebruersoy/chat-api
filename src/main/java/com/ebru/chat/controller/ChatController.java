package com.ebru.chat.controller;

import com.ebru.chat.model.ChatMessage;
import com.ebru.chat.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ebru Ersoy Göksal
 */
@RestController
public class ChatController {

    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("messages")
    public List<ChatMessage> getMessages() {
        return chatService.getMessages();
    }

    @PostMapping("send")
    public void sendMessage(@RequestBody ChatMessage message) {
        message.setTimestamp(LocalDateTime.now().toString());
        System.out.println(message);
        //kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
    }


}
