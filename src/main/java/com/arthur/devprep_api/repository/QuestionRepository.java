package com.arthur.devprep_api.repository;

import com.arthur.devprep_api.entity.Question;
import com.arthur.devprep_api.enums.Difficulty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Page<Question> findByDifficulty(Difficulty difficulty, Pageable pageable);

    Page<Question> findByTopicContainingIgnoreCase(String topic, Pageable pageable);

}
