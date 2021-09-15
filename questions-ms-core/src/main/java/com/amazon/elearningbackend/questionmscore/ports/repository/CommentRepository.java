package com.amazon.elearningbackend.questionmscore.ports.repository;

import com.amazon.elearningbackend.questionmscore.model.Comment;

import java.util.List;

public interface CommentRepository {

    Comment save(Comment comment);
    List<Comment> findAll();
}
