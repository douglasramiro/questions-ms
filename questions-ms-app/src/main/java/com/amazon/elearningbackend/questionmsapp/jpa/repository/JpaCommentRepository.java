package com.amazon.elearningbackend.questionmsapp.jpa.repository;

import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaComment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaCommentRepository extends JpaRepository<JpaComment, String> {

}
