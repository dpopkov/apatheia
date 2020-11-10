package ru.dpopkov.apatheia.qabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping("/list")
    public String listQuestions(Model model) {
        return "list-questions";
    }
}
