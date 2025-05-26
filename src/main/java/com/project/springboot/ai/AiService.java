package com.project.springboot.ai;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

   private ChatClient chatClient;
    public AiService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }
    public String chat(String prompt){
        chatClient.prompt(prompt).call().content();
        return prompt;
    }
}
