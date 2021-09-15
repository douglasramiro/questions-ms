package com.amazon.elearningbackend.questionmscore.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class InvalidObjectException extends  RuntimeException{
    @Getter
    private List<String> errors ;

    public InvalidObjectException(List<String> errors){
        super(errors.toString());
        this.errors = errors;
    }
}
