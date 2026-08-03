package com.arthur.devprep_api.dto;

import com.arthur.devprep_api.enums.Difficulty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuestionRequest {

    @Schema(
            description = "Pergunta da entrevista",
            example = "O que é Injeção de Dependência?"
    )
    @NotBlank(message = "Pergunta não pode estar em branco.")
    private String question;

    @Schema(
            description = "Resposta esperada para a pergunta",
            example = "É um padrão de projeto que permite fornecer dependências a uma classe."
    )
    @NotBlank(message = "Resposta não pode estar em branco.")
    private String answer;

    @Schema(
            description = "Nível de dificuldade da questão",
            example = "MEDIUM"
    )
    @NotNull(message = "Você deve inserir uma dificuldade.")
    private Difficulty difficulty;

    @Schema(
            description = "Tópico da questão",
            example = "Spring Boot"
    )
    @NotBlank(message = "Tópico não pode estar em branco.")
    private String topic;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}




