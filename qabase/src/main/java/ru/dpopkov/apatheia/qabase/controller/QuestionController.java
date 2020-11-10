package ru.dpopkov.apatheia.qabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dpopkov.apatheia.qabase.dao.QuestionDAO;
import ru.dpopkov.apatheia.qabase.entity.Question;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionController(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @RequestMapping("/list")
    public String listQuestions(Model model) {
        List<Question> questions = questionDAO.getQuestions();
        model.addAttribute("allQuestions", questions);
        return "list-questions";
    }
}
