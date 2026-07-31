package com.arthur.devprep_api.service;

import com.arthur.devprep_api.dto.QuestionRequest;
import com.arthur.devprep_api.dto.QuestionResponse;
import com.arthur.devprep_api.entity.Question;
import com.arthur.devprep_api.enums.Difficulty;
import com.arthur.devprep_api.exception.QuestionNotFoundException;
import com.arthur.devprep_api.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private QuestionResponse toResponse(Question question) {
        return new QuestionResponse(
                question.getId(),
                question.getQuestion(),
                question.getAnswer(),
                question.getDifficulty(),
                question.getTopic(),
                question.getCreatedAt()
        );
    }

    private Question toEntity(QuestionRequest request) {
        return new Question(
                request.getQuestion(),
                request.getAnswer(),
                request.getDifficulty(),
                request.getTopic()
        );
    }

    @Transactional
    public QuestionResponse createQuestion(QuestionRequest request) {
        Question question = toEntity(request);
        Question questionSalva = questionRepository.save(question);
        return toResponse(questionSalva);
    }

    public QuestionResponse findById(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Id não encontrado"));
        return toResponse(question);

    }

    public Page<QuestionResponse> listAllQuestions(Pageable pageable) {
        Page<Question> questions = questionRepository.findAll(pageable);
        return questions.map(this::toResponse);
    }

    @Transactional
    public QuestionResponse updateQuestion(Long id, QuestionRequest request) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Id não encontrado"));

        question.setQuestion(request.getQuestion());
        question.setAnswer(request.getAnswer());
        question.setDifficulty(request.getDifficulty());
        question.setTopic(request.getTopic());

        questionRepository.save(question);
        return toResponse(question);


    }

    @Transactional
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Id não encontrado"));
        questionRepository.delete(question);
    }

    public List<QuestionResponse> listByDifficulty(Difficulty difficulty) {
        List<Question> questions = questionRepository.findByDifficulty(difficulty);
        return questions.stream()
                .map(this::toResponse)
                .toList();

    }

    public List<QuestionResponse> listByTopic(String topic) {
        List<Question> questions = questionRepository.findByTopicContainingIgnoreCase(topic);
        return questions.stream()
                .map(this::toResponse)
                .toList();
    }

    public QuestionResponse chooseRandomQuestion() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new QuestionNotFoundException("Nenhuma pergunta encontrada");
        }
        Random random = new Random();
        int indice = random.nextInt(questions.size());
        Question question = questions.get(indice);
        return toResponse(question);

    }
}

