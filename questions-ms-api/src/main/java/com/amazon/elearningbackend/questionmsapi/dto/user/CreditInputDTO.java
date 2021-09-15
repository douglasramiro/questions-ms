package com.amazon.elearningbackend.questionmsapi.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditInputDTO {

    private String userId;
    private Integer creditAmount;

}
