package com.arthur.devprep_api.controller;

import com.arthur.devprep_api.dto.QuestionRequest;
import com.arthur.devprep_api.dto.QuestionResponse;
import com.arthur.devprep_api.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionResponse createQuestion(@Valid @RequestBody QuestionRequest request) {
        return questionService.createQuestion(request);
    }

    @GetMapping("/{id}")
    public QuestionResponse findQuestionById(@PathVariable Long id){
        return questionService.findById(id);
    }
}
