package com.amazon.questionapp.adapters;

import com.amazon.elearningbackend.questionmscore.model.Comment;
import com.amazon.elearningbackend.questionmscore.ports.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommentRepositoryImpl  implements CommentRepository {

    private  List<Comment> comments = new ArrayList<>();

    @Override
    public Comment save(Comment comment) {
        comment.setId(UUID.randomUUID().toString());
        comments.add(comment);
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }
}
