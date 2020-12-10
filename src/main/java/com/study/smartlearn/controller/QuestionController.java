package com.study.smartlearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @GetMapping("")
    public String getQuestionPage() {
        return "/question/question";
    }
}
