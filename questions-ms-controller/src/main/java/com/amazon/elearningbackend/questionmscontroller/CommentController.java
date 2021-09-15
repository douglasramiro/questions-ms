package com.amazon.elearningbackend.questionmscontroller;


import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentOutputDTO;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import com.amazon.elearningbackend.questionmscore.model.Comment;
import com.amazon.elearningbackend.questionmscore.usecases.CommentService;
import com.amazon.elearningbackend.questionmscore.usecases.QuestionService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final QuestionService questionService;

    public CommentOutputDTO save(CommentInputDTO commentInputDTO) throws InvalidObjectException {
        Comment comment = new Comment(commentInputDTO.getComment(), questionService.recoverQuestionById(commentInputDTO.getQuestionId()));
        commentService.creteNewComment(comment);
        return new CommentOutputDTO(comment.getId(),comment.getComment(),comment.getQuestion().getId());
    }

    public List<CommentOutputDTO> listAll(){
        List<CommentOutputDTO> returnList = new ArrayList<>();
        List<Comment> comments = commentService.listAllComments();
        comments.forEach(comment -> {
            returnList.add(new CommentOutputDTO(comment.getId(),comment.getComment(),comment.getQuestion().getId()));
        });
        return returnList;
    }
}
