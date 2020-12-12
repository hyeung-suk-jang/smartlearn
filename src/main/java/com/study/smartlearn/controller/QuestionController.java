package com.study.smartlearn.controller;

import com.study.smartlearn.domain.Question;
import com.study.smartlearn.dto.QuestionDto;
import com.study.smartlearn.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/create")
    public String getQuestionPage() {
        return "/question/creation";
    }

    @PostMapping("/create")
    public String create(QuestionDto questionDto) {
        questionService.saveQuestion(questionDto);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Question> questions = questionService.getList();
        model.addAttribute("list", questions);
        return "/question/list";
    }
}
