package delivery_feedback_backend;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import delivery_feedback_backend.service.GroqService;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class FeedbackController {

    private final GroqService groqService;

    public FeedbackController(GroqService groqService) {
        this.groqService = groqService;
    }

    @PostMapping("/api/feedback")
    public Map<String, String> receberFeedback(
            @RequestBody Map<String, String> dados) {

        String feedback = dados.get("feedback");

        String analise = groqService.analisar(feedback);

        return Map.of(
                "mensagem", analise);
    }

}