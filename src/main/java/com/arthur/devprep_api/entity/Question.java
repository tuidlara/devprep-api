package com.arthur.devprep_api.entity;

import com.arthur.devprep_api.enums.Difficulty;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Question {

    protected Question() {

    }

    public Question(String question, String answer, Difficulty difficulty, String topic) {
        this.question = question;
        this.answer = answer;
        this.difficulty = difficulty;
        this.topic = topic;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String topic;

    private LocalDateTime createdAt;

    @PrePersist
    public void aoCriar() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
