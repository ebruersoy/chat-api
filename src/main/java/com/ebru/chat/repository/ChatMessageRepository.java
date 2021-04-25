package com.ebru.chat.repository;

import com.ebru.chat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ebru Ersoy Göksal
 */
@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}
