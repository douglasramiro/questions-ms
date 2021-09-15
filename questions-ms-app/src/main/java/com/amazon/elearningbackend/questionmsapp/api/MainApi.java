package com.amazon.elearningbackend.questionmsapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainApi {

    @GetMapping
    public String application(){
        return "Question MS Application";
    }
}
