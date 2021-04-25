package com.ebru.chat.controller;

import com.ebru.chat.dto.ChatMessageDto;
import com.ebru.chat.exception.GeneralExceptionHandler;
import com.ebru.chat.repository.ChatMessageRepository;
import com.ebru.chat.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ebru Ersoy Göksal
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ChatController.class,ChatService.class, ChatMessageRepository.class,SimpMessagingTemplate.class, GeneralExceptionHandler.class})
@WebMvcTest
class ChatControllerIntegrationTest {

    @Autowired
    ChatController chatController;
    @MockBean
    ChatService chatService;

    @MockBean
    SimpMessagingTemplate simpMessagingTemplate;


    @MockBean
    ChatMessageRepository chatMessageRepository;

    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext wac;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup( chatController).setControllerAdvice(new GeneralExceptionHandler())
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_get_404_with_empty_message() throws Exception {
          mockMvc.perform(MockMvcRequestBuilders
                    .post("/send")
                    .content(new ObjectMapper().writeValueAsString((new ChatMessageDto())))
                    .contentType("application/json"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isNotFound())
                    .andReturn();
    }

}