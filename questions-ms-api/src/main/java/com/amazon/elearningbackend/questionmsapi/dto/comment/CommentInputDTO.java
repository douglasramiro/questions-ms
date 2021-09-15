package com.amazon.elearningbackend.questionmsapi.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInputDTO {
    private String comment;
    private String questionId;
}
