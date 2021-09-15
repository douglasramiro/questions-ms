package com.amazon.elearningbackend.questionmsapp.mapper;

import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaComment;
import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaQuestion;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import com.amazon.elearningbackend.questionmscore.model.Comment;
import com.amazon.elearningbackend.questionmscore.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentMapper {

    public JpaComment toJpaComment(Comment comment){
        //QuestionMapper questionMapper = new QuestionMapper();
        Question question = comment.getQuestion();
        JpaQuestion jpaQuestion = new JpaQuestion(question.getId(),question.getTitle(), question.getQuestion(),question.getUserId(),null);
        return new JpaComment(comment.getId(), comment.getComment(), jpaQuestion);
    }

    public Comment toComment(JpaComment jpaComment) throws InvalidObjectException {
        JpaQuestion jpaQuestion = jpaComment.getQuestion();
        Question question = new Question(jpaQuestion.getTitle(),jpaQuestion.getQuestion(),jpaQuestion.getUserId());
        return  new Comment(jpaComment.getId(), jpaComment.getComment(),question);
    }


    public List<Comment> toComments(List<JpaComment> jpaComments) {
        List<Comment> comments = new ArrayList<>();
        jpaComments.forEach(comment -> {
            try {
                comments.add(toComment(comment));
            } catch (InvalidObjectException e) {
                throw new RuntimeException(e);
            }
        });
        return comments;
    }
}
