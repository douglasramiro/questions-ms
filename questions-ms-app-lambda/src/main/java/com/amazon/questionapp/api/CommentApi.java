package com.amazon.questionapp.api;

import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentOutputDTO;
import com.amazon.elearningbackend.questionmscontroller.CommentController;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/api/comment")
@RequiredArgsConstructor
public class CommentApi {

    private final CommentController commentController;

    @POST
    public CommentOutputDTO save(CommentInputDTO commentInputDTO) throws InvalidObjectException {
        return commentController.save(commentInputDTO);
    }

    @GET
    public List<CommentOutputDTO> listAll(){
        return commentController.listAll();
    }
}
