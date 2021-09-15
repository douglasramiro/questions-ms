package com.amazon.elearningbackend.questionmscore.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }
}
