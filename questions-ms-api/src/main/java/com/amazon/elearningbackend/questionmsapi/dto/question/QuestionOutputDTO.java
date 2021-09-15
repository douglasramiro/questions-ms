package com.amazon.elearningbackend.questionmsapi.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOutputDTO {

    private String id;
    private String title;
    private String question;
    private String userId;

}
