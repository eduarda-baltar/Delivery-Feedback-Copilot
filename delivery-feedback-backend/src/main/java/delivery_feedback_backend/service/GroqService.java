
package delivery_feedback_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

@Service
public class GroqService {

    private final RestClient restClient;

    public GroqService(@Value("${groq.api.key}") String apiKey) {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.groq.com/openai/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    @SuppressWarnings("deprecation")
    public String analisar(String feedback) {

        Map<String, Object> corpo = Map.of(
                "model", "openai/gpt-oss-20b",
                "messages", List.of(
                        Map.of(
                                "role", "system",
                                "content", "Você é um especialista em análise de feedbacks de delivery. Identifique o sentimento do cliente, os problemas relatados, os elogios e sugira melhorias. Responda em português, de forma clara e objetiva."
                        ),
                        Map.of(
                                "role", "user",
                                "content", feedback
                        )
                ),
                "temperature", 0.2
        );

        JsonNode resposta = restClient.post()
                .uri("/chat/completions")
                .body(corpo)
                .retrieve()
                .body(JsonNode.class);

        return resposta
                .path("choices")
                .path(0)
                .path("message")
                .path("content")
                .asText();
    }
}
