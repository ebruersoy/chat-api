package com.ebru.chat.repository;

import com.ebru.chat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ebru Ersoy Göksal
 */
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}
