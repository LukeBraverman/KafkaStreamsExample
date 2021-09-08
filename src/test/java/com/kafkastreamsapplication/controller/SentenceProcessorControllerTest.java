package com.kafkastreamsapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreamsapplication.model.StringToProcess;
import com.kafkastreamsapplication.service.SentenceProcessorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)

class SentenceProcessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    SentenceProcessorController sentenceProcessorController;

    @Mock
    SentenceProcessorService sentenceProcessorService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sentenceProcessorController)
                .build();
    }

    @Test
    public void whenStringIsSent_thenRecieveWordCountInWordBody() throws Exception {
        //given
        String testSentence = "The The Cat Was Was Was Green";

        HashMap<String, Integer> wordCount = new HashMap<>();
        wordCount.put("The", 2);
        wordCount.put("Cat", 1);
        wordCount.put("Was", 3);
        wordCount.put("Green", 1);
        String wordCountString = wordCount.toString();

       lenient().when(sentenceProcessorService.returnWordCountFromStringUsingKafkaStreams(testSentence)).thenReturn(wordCountString);


        //when
        String jsonSting = "{\"message\" : \"testMessage\"}";
        final MvcResult mvcResult = mockMvc.perform(
                get("/GetWordCount")
                        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonSting))
                .andExpect(status().isOk())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();

        //then
        assertEquals(wordCount.toString(),content);





    }
}