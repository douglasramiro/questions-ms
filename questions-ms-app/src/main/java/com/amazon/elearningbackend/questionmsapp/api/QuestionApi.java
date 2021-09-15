package com.amazon.elearningbackend.questionmsapp.api;

import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionOutputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionWithCommentsOutputDTO;
import com.amazon.elearningbackend.questionmscontroller.QuestionController;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionApi {

    private final QuestionController questionController;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionOutputDTO save(@RequestBody QuestionInputDTO questionInputDTO) throws InvalidObjectException {
        return questionController.save(questionInputDTO);
    }

    @GetMapping
    public List<QuestionOutputDTO> listAll(){
        return questionController.listAll();
    }

    @GetMapping("/with-comments")
    public List<QuestionWithCommentsOutputDTO> listAllWithComments(){
        return questionController.listAllWithComments();
    }
}
