package com.arthur.devprep_api.exception;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(String mensagem) {
        super(mensagem);
    }
}
