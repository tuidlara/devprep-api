package com.arthur.devprep_api.repository;

import com.arthur.devprep_api.entity.Question;
import com.arthur.devprep_api.enums.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByDifficulty(Difficulty difficulty);

    List<Question> findByTopicContainingIgnoreCase(String topic);

}
