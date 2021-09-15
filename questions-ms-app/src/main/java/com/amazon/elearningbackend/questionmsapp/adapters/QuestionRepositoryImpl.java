package com.amazon.elearningbackend.questionmsapp.adapters;

import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaQuestion;
import com.amazon.elearningbackend.questionmsapp.jpa.repository.JpaQuestionRepository;
import com.amazon.elearningbackend.questionmsapp.mapper.QuestionMapper;
import com.amazon.elearningbackend.questionmscore.model.Question;
import com.amazon.elearningbackend.questionmscore.ports.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final JpaQuestionRepository jpaQuestionRepository;
    private final QuestionMapper questionMapper;

    @Override
    public Question save(Question question) {
        JpaQuestion jpaQuestion = questionMapper.toJpaQuestion(question);
        jpaQuestionRepository.save(jpaQuestion);
        return questionMapper.toQuestion(jpaQuestion);
    }

    @Override
    public List<Question> findAll() {
        List<JpaQuestion> jpaQuestions = jpaQuestionRepository.findAll();
        return questionMapper.toQuestions(jpaQuestions);
    }

    @Override
    public List<Question> findAllWithComments() {
        List<JpaQuestion> jpaQuestions = jpaQuestionRepository.findAllWithComments();
        return questionMapper.toQuestions(jpaQuestions);
    }

    @Override
    public Optional<Question> findById(String id) {
        Optional<JpaQuestion> jpaQuestion = jpaQuestionRepository.findById(id);
        if (jpaQuestion.isPresent()){
            return Optional.of(questionMapper.toQuestion(jpaQuestion.get()));
        }else{
            return Optional.empty();
        }
    }
}
