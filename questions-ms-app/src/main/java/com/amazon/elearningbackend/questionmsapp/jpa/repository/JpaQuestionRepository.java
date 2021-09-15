package com.amazon.elearningbackend.questionmsapp.jpa.repository;

import com.amazon.elearningbackend.questionmsapp.jpa.entity.JpaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface JpaQuestionRepository extends JpaRepository<JpaQuestion, String> {

    @Query("SELECT q from JpaQuestion q left join q.comments")
    List<JpaQuestion> findAllWithComments();
}
