package com.amazon.elearningbackend.questionmsapp.adapters;

import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaComment;
import com.amazon.elearningbackend.questionmsapp.jpa.repository.JpaCommentRepository;
import com.amazon.elearningbackend.questionmsapp.mapper.CommentMapper;
import com.amazon.elearningbackend.questionmscore.model.Comment;
import com.amazon.elearningbackend.questionmscore.ports.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;
    private final CommentMapper commentMapper;

    @Override
    public Comment save(Comment comment) {
        JpaComment jpa = commentMapper.toJpaComment(comment);
        jpaCommentRepository.save(jpa);
        return commentMapper.toComment(jpa);
    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.toComments(jpaCommentRepository.findAll());
    }
}
