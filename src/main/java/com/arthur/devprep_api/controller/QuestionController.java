package com.arthur.devprep_api.controller;

import com.arthur.devprep_api.dto.QuestionRequest;
import com.arthur.devprep_api.dto.QuestionResponse;
import com.arthur.devprep_api.enums.Difficulty;
import com.arthur.devprep_api.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@Tag(name = "Questões", description = "Operações relacionadas às questões")

public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Operation(
            summary = "Criar uma questão.",
            description = "Cadastra uma nova questão.")

    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Questão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionResponse createQuestion(@Valid @RequestBody QuestionRequest request) {
        return questionService.createQuestion(request);
    }

    @Operation(
            summary = "Buscar questão pelo ID",
            description = "Retorna uma questão a partir do seu identificador."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Questão encontrada"),
            @ApiResponse(responseCode = "404", description = "Questão não encontrada")
    })
    @GetMapping("/{id}")
    public QuestionResponse findQuestionById(@PathVariable Long id) {
        return questionService.findById(id);
    }

    @Operation(
            summary = "Listar todas as questões",
            description = "Retorna uma lista paginada de todas as questões cadastradas."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public Page<QuestionResponse> listAllQuestions(Pageable pageable) {
        return questionService.listAllQuestions(pageable);
    }

    @Operation(
            summary = "Atualizar questão",
            description = "Atualiza uma questão a partir do seu identificador."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Questão atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "404", description = "Questão não encontrada"),

    })
    @PutMapping("/{id}")
    public QuestionResponse updateQuestion(@PathVariable Long id, @Valid @RequestBody QuestionRequest request) {
        return questionService.updateQuestion(id, request);
    }

    @Operation(
            summary = "Excluir questão",
            description = "Exclui uma questão a partir do seu identificador."
    )

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Questão removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Questão não encontrada"),
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @Operation(
            summary = "Buscar questões por dificuldade",
            description = "Retorna uma lista paginada de questões filtradas pela dificuldade."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Questões encontradas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dificuldade informada é inválida")
    })
    @GetMapping("/difficulty/{difficulty}")
    public Page<QuestionResponse> listByDifficulty(@PathVariable Difficulty difficulty, Pageable pageable) {
        return questionService.listByDifficulty(difficulty, pageable);
    }

    @Operation(
            summary = "Buscar questões por tópico",
            description = "Retorna uma lista paginada de questões cujo tópico contém o texto informado."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Questões encontradas com sucesso")
    })
    @GetMapping("/topic/{topic}")
    public Page<QuestionResponse> listByTopic(@PathVariable String topic, Pageable pageable) {
        return questionService.listByTopic(topic, pageable);
    }

    @Operation(
            summary = "Obter uma questão aleatória",
            description = "Retorna uma questão escolhida aleatoriamente dentre as cadastradas."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Questão retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhuma questão cadastrada")
    })
    @GetMapping("/random")
    public QuestionResponse chooseRandomQuestion() {
        return questionService.chooseRandomQuestion();
    }

}
