package com.arthur.devprep_api.dto;

import com.arthur.devprep_api.enums.Difficulty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuestionRequest {

    @NotBlank(message = "Pergunta não pode estar em branco.")
    private String question;

    @NotBlank(message = "Resposta não pode estar em branco.")
    private String answer;

    @NotNull(message = "Você deve inserir uma dificuldade.")
    private Difficulty difficulty;

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




