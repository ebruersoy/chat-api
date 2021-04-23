package com.ebru.chat.service;

import com.ebru.chat.dto.ChatMessageDto;
import com.ebru.chat.model.ChatMessage;
import com.ebru.chat.repository.ChatMessageRepository;
import com.ebru.chat.utils.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ebru Ersoy Göksal
 */
@Service
public class ChatService {

    ChatMessageRepository repository;

    public ChatService(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public List<ChatMessageDto> getMessages(){
        List<ChatMessage> messages = repository.findAll();
        List<ChatMessageDto> response = messages.stream().map(Util::modelToDto).collect(Collectors.toList());;
        return response;
    }

    public void saveMessage(ChatMessage message) {
        repository.save(message);
    }
}
