package com.amazon.elearningbackend.questionmsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessagesDTO {
    private List<ExceptionMessageDTO> messages;

    public void addExceptionMessage(ExceptionMessageDTO exceptionMessageDTO){
        getMessages().add(exceptionMessageDTO);
    }

    public List<ExceptionMessageDTO> getMessages() {
        if (messages == null){
            messages = new ArrayList<>();
        }
        return messages;
    }
}
