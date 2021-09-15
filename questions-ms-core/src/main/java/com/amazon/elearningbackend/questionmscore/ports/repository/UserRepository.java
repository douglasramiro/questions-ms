package com.amazon.elearningbackend.questionmscore.ports.repository;

import com.amazon.elearningbackend.questionmsapi.dto.user.CreditInputDTO;
import com.amazon.elearningbackend.questionmsapi.dto.user.UserOutputDTO;

public interface UserRepository {
    UserOutputDTO recoverUserById(String id);

    void reduceCredit(CreditInputDTO creditInputDTO);
}
