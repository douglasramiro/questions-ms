package com.amazon.elearningbackend.questionmscore.usecases;




import com.amazon.elearningbackend.questionmsapi.dto.user.CreditInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.user.UserOutputDTO;
import com.amazon.elearningbackend.questionmscore.exceptions.BusinessException;
import com.amazon.elearningbackend.questionmscore.exceptions.ResourceNotFoundException;
import com.amazon.elearningbackend.questionmscore.model.Question;
import com.amazon.elearningbackend.questionmscore.ports.repository.QuestionRepository;
import com.amazon.elearningbackend.questionmscore.ports.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public void creteNewQuestion(Question question){
        UserOutputDTO user = userRepository.recoverUserById(question.getUserId());
        if (user.getCredits() <= 0){
            throw new BusinessException("Not enough credits to create a question!");
        }
        CreditInputDTO creditInputDTO = new CreditInputDTO(question.getUserId(),user.getCredits());
        userRepository.reduceCredit(creditInputDTO);
        questionRepository.save(question);
    }

    public List<Question> listAllQuestions(){
        return questionRepository.findAll();
    }

    public List<Question> listAllQuestionsWithComments(){
        return questionRepository.findAllWithComments();
    }

    public Question recoverQuestionById(String id) {
        return questionRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Question "+id+" not found"));
    }
}
