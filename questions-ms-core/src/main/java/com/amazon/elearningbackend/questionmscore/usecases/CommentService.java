package com.amazon.elearningbackend.questionmscore.usecases;

import com.amazon.elearningbackend.questionmscore.model.Comment;
import com.amazon.elearningbackend.questionmscore.model.Question;
import com.amazon.elearningbackend.questionmscore.ports.repository.CommentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final QuestionService questionService;

    public void creteNewComment(Comment comment){
        Question question = questionService.recoverQuestionById(comment.getQuestion().getId());
        comment.setQuestion(question);
        commentRepository.save(comment);
    }

    public List<Comment> listAllComments(){
        return commentRepository.findAll();
    }
}
