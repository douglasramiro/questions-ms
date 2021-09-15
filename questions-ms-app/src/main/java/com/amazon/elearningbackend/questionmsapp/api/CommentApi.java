package com.amazon.elearningbackend.questionmsapp.api;

import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.comment.CommentOutputDTO;
import com.amazon.elearningbackend.questionmscontroller.CommentController;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentApi {

    private final CommentController commentController;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentOutputDTO save(@RequestBody CommentInputDTO commentInputDTO) throws InvalidObjectException {
        return commentController.save(commentInputDTO);
    }

    @GetMapping
    public List<CommentOutputDTO> listAll(){
        return commentController.listAll();
    }
}
