package com.arthur.devprep_api.repository;

import com.arthur.devprep_api.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
