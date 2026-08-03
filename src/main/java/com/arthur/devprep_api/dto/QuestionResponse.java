package com.arthur.devprep_api.dto;

import com.arthur.devprep_api.enums.Difficulty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class QuestionResponse {

    @Schema(description = "Identificador único da questão", example = "1")
    private Long id;

    @Schema(description = "Pergunta da entrevista")
    private String question;

    @Schema(description = "Resposta da pergunta")
    private String answer;

    @Schema(description = "Nível de dificuldade da questão")
    private Difficulty difficulty;

    @Schema(description = "Tópico da questão")
    private String topic;

    @Schema(
            description = "Data e hora de criação da questão",
            example = "2026-08-03T10:30:15")
    private LocalDateTime createdAt;

    public QuestionResponse(Long id, String question, String answer, Difficulty difficulty, String topic, LocalDateTime createdAt) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.topic = topic;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }


    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
