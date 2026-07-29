package com.arthur.devprep_api.dto;

import com.arthur.devprep_api.enums.Difficulty;

import java.time.LocalDateTime;

public class QuestionResponse {

    private Long id;
    private String question;
    private String answer;
    private Difficulty difficulty;
    private String topic;
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
