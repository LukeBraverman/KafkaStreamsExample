package com.kafkastreamsapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreamsapplication.model.StringToProcess;
import com.kafkastreamsapplication.service.SentenceProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SentenceProcessorController {

    private SentenceProcessorService sentenceProcessorService;

    @GetMapping("/GetWordCount")
    public ResponseEntity<String> getWordCountInSentence(@RequestBody StringToProcess stringToProcess) throws JsonProcessingException {
        String wordCount = sentenceProcessorService.returnWordCountFromStringUsingKafkaStreams(stringToProcess.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(wordCount);
    }




}
