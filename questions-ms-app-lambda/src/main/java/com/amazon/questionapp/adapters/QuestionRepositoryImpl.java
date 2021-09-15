package com.amazon.questionapp.adapters;

import com.amazon.elearningbackend.questionmscore.model.Question;
import com.amazon.elearningbackend.questionmscore.ports.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class QuestionRepositoryImpl implements QuestionRepository {

    private List<Question> questions = new ArrayList<>();

    @Override
    public Question save(Question question) {
        question.setId(UUID.randomUUID().toString());
        questions.add(question);
        return question;
    }

    @Override
    public List<Question> findAll() {
        return questions;
    }

    @Override
    public List<Question> findAllWithComments() {
        return questions;
    }

    @Override
    public Optional<Question> findById(String id) {
        return questions.stream().filter(q-> q.getId().equals(id)).findFirst();
    }
}
