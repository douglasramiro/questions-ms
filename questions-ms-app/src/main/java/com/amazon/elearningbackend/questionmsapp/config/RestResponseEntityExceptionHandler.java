package com.amazon.elearningbackend.questionmsapp.config;


import com.amazon.elearningbackend.questionmsapi.dto.ExceptionMessageDTO;
import com.amazon.elearningbackend.questionmsapi.dto.ExceptionMessagesDTO;
import com.amazon.elearningbackend.questionmscore.exceptions.BusinessException;
import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import com.amazon.elearningbackend.questionmscore.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidObjectException.class)
    public ResponseEntity<Object> handleInvalidObjectException(InvalidObjectException ex) {
        ExceptionMessagesDTO messages = new ExceptionMessagesDTO();
        ex.getErrors().forEach(msg->{
            messages.addExceptionMessage(new ExceptionMessageDTO(msg));
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
        ExceptionMessagesDTO messages = new ExceptionMessagesDTO();
        messages.addExceptionMessage(new ExceptionMessageDTO(ex.getMessage()));
        return ResponseEntity.badRequest().body(messages);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(Exception ex) {
        ExceptionMessagesDTO messages = new ExceptionMessagesDTO();
        messages.addExceptionMessage(new ExceptionMessageDTO(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messages);
    }
}
