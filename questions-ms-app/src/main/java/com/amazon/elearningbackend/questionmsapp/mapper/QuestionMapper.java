package com.amazon.elearningbackend.questionmsapp.mapper;

import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaComment;
import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaQuestion;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import com.amazon.elearningbackend.questionmscore.model.Comment;
import com.amazon.elearningbackend.questionmscore.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionMapper {


    public JpaQuestion toJpaQuestion(Question question){
        CommentMapper commentMapper = new CommentMapper();
        List<JpaComment> comments = new ArrayList<>();
        question.getComments().forEach(comment -> {
            comments.add(commentMapper.toJpaComment(comment));
        });
        return new JpaQuestion(question.getId(),question.getTitle(),question.getQuestion(),question.getUserId(),comments);
    }

    @SneakyThrows
    public Question toQuestion(JpaQuestion jpaQuestion) {
        CommentMapper commentMapper = new CommentMapper();
        List<Comment> comments = new ArrayList<>();
        jpaQuestion.getComments().forEach(comment -> {
            try {
                comments.add(commentMapper.toComment(comment));
            } catch (InvalidObjectException e) {
                throw new RuntimeException(e);
            }
        });
        Question question = new Question(jpaQuestion.getTitle(), jpaQuestion.getQuestion(), jpaQuestion.getUserId(), comments);
        question.setId(jpaQuestion.getId());
        return question;
    }

    public List<Question> toQuestions(List<JpaQuestion> jpaQuestions) {
        List<Question> questions = new ArrayList<>();
        jpaQuestions.forEach(jpa -> {
            questions.add(toQuestion(jpa));
        });
        return questions;
    }
}
