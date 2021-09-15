package com.amazon.elearningbackend.questionmscore.ports.repository;

import com.amazon.elearningbackend.questionmscore.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    Question save(Question question);

    List<Question> findAll();

    List<Question> findAllWithComments();

    Optional<Question> findById(String id);
}
