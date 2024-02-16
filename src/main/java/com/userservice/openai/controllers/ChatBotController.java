package com.userservice.openai.controllers;

import com.userservice.openai.dtos.ChatBotRequest;
import com.userservice.openai.dtos.ChatBotResponse;
import com.userservice.openai.dtos.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatBotController {

    private final  RestTemplate restTemplate;

    @Value("${openai.chatgtp.model}")
    private String model;

    @Value("${openai.chatgtp.max-completions}")
    private int maxCompletions;

    @Value("${openai.chatgtp.temperature}")
    private double temperature;

    @Value("${openai.chatgtp.max_tokens}")
    private int maxTokens;

    @Value("${openai.chatgtp.api.url}")
    private String apiUrl;

    @PostMapping("/chat")
    public ChatBotResponse chat(@RequestParam("prompt") String prompt) {

        ChatBotRequest request = new ChatBotRequest(model,
                List.of(new Message("user", prompt)),
                maxCompletions,
                temperature,
                maxTokens);

        ChatBotResponse chatBotResponse = restTemplate.postForObject(apiUrl, request, ChatBotResponse.class);
        return chatBotResponse;
    }
}
