package com.arthur.devprep_api.controller;

import com.arthur.devprep_api.dto.QuestionRequest;
import com.arthur.devprep_api.dto.QuestionResponse;
import com.arthur.devprep_api.enums.Difficulty;
import com.arthur.devprep_api.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public QuestionResponse findQuestionById(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @GetMapping
    public Page<QuestionResponse> listAllQuestions(Pageable pageable) {
        return questionService.listAllQuestions(pageable);
    }

    @PutMapping("/{id}")
    public QuestionResponse updateQuestion(@PathVariable Long id, @Valid @RequestBody QuestionRequest request) {
        return questionService.updateQuestion(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping("/difficulty/{difficulty}")
    public Page<QuestionResponse> listByDifficulty(@PathVariable Difficulty difficulty , Pageable pageable) {
        return questionService.listByDifficulty(difficulty, pageable);
    }

    @GetMapping("/topic/{topic}")
    public Page<QuestionResponse> listByTopic(@PathVariable String topic, Pageable pageable) {
        return questionService.listByTopic(topic, pageable);
    }

    @GetMapping("/random")
    public QuestionResponse chooseRandomQuestion() {
        return questionService.chooseRandomQuestion();
    }

}
