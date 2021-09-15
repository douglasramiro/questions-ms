package com.amazon.questionapp.api;

import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionOutputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.question.QuestionWithCommentsOutputDTO;
import com.amazon.elearningbackend.questionmscontroller.QuestionController;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/question")
@RequiredArgsConstructor
public class QuestionApi {

    private final QuestionController questionController;

    @POST
    public QuestionOutputDTO save(QuestionInputDTO questionInputDTO) throws InvalidObjectException {
        return questionController.save(questionInputDTO);
    }

    @GET
    public List<QuestionOutputDTO> listAll(){
        return questionController.listAll();
    }

    @GET()
    @Path("/with-comments")
    public List<QuestionWithCommentsOutputDTO> listAllWithComments(){
        return questionController.listAllWithComments();
    }
}
