package com.amazon.questionapp.adapters;

import com.amazon.elearningbackend.questionmsapi.dto.user.CreditInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.user.UserOutputDTO;
import com.amazon.elearningbackend.questionmscore.exceptions.ResourceNotFoundException;
import com.amazon.elearningbackend.questionmscore.ports.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private static UserOutputDTO userOutputDTO = new UserOutputDTO("b17b200a-e262-4431-adbb-406c017579f2","douglars@amazon.com","Douglas Ramiro",5);


    @Override
    public UserOutputDTO recoverUserById(String id) {
        if (userOutputDTO.getId().equals(id)) {
            return userOutputDTO;
        }else{
            throw new ResourceNotFoundException("User "+id+" not found");
        }
    }

    @Override
    public void reduceCredit(CreditInputDTO creditInputDTO) {
        userOutputDTO.setCredits(userOutputDTO.getCredits()-1);
    }
}
