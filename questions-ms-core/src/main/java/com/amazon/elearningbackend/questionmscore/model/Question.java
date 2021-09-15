package com.amazon.elearningbackend.questionmscore.model;

import com.amazon.elearningbackend.questionmscore.exceptions.InvalidObjectException;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Question {

    private String id;

    private String title;

    private String question;

    private String userId;

    private List<Comment> comments;

    public Question(String title, String question, String userId) throws InvalidObjectException {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.question = question;
        this.userId = userId;
        validateQuestion();
    }

    public Question(String title, String question, String userId, List<Comment> comments) throws InvalidObjectException {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.question = question;
        this.userId = userId;
        this.comments = comments;
        validateQuestion();
    }

    public void validateQuestion() throws InvalidObjectException {
        List<String> errors = new ArrayList<>();
        if (title == null || "".equals(title) || title.length() < 10 || title.length() > 255){
            errors.add("A title must be provided with at least 10 characters and less than 255");
        }
        if (question == null || "".equals(question) || question.length() < 15 || question.length() > 255) {
            errors.add("A question must be provided with at least 15 characters and less than 255");
        }
        if (userId == null){
            errors.add("A question must be associated to an user id.");
        }
        if (errors.size() > 0){
            throw new InvalidObjectException(errors);
        }
    }

    public List<Comment> getComments() {
        if (comments == null){
            this.comments = new ArrayList<>();
        }
        return comments;
    }
}
