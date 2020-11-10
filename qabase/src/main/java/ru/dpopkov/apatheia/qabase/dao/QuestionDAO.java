package ru.dpopkov.apatheia.qabase.dao;

import ru.dpopkov.apatheia.qabase.entity.Question;

import java.util.List;

public interface QuestionDAO {

    List<Question> getQuestions();
}
