package com.amazon.elearningbackend.questionmscontroller;


import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentOutputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionOutputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionWithCommentsOutputDTO;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import com.amazon.elearningbackend.questionmscore.model.Question;
import com.amazon.elearningbackend.questionmscore.usecases.QuestionService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    public QuestionOutputDTO save(QuestionInputDTO questionInputDTO) throws InvalidObjectException {
        Question question = new Question(questionInputDTO.getTitle(), questionInputDTO.getQuestion(),questionInputDTO.getUserId());
        questionService.creteNewQuestion(question);
        return new QuestionOutputDTO(question.getId(), question.getTitle(), question.getQuestion(), question.getUserId());
    }

    public List<QuestionOutputDTO> listAll(){
        List<QuestionOutputDTO> returnList = new ArrayList<>();
        List<Question> questions = questionService.listAllQuestions();
        questions.forEach(question -> {
            returnList.add(new QuestionOutputDTO(question.getId(), question.getTitle(), question.getQuestion(), question.getUserId()));
        });
        return returnList;
    }

    public List<QuestionWithCommentsOutputDTO> listAllWithComments(){
        List<QuestionWithCommentsOutputDTO> returnList = new ArrayList<>();
        List<Question> questions = questionService.listAllQuestionsWithComments();
        questions.forEach(question -> {
            QuestionWithCommentsOutputDTO questionWithCommentsOutputDTO = new QuestionWithCommentsOutputDTO(question.getId(), question.getTitle(), question.getQuestion(), question.getUserId());
            question.getComments().forEach(comment -> {
                questionWithCommentsOutputDTO.addComment(new CommentOutputDTO(comment.getId(),comment.getComment(),comment.getQuestion().getId()));
            });
            returnList.add(questionWithCommentsOutputDTO);
        });
        return returnList;
    }
}
