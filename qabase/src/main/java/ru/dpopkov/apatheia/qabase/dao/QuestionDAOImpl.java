package ru.dpopkov.apatheia.qabase.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dpopkov.apatheia.qabase.entity.Question;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public QuestionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Question> getQuestions() {
        Session session = sessionFactory.getCurrentSession();
        Query<Question> query = session.createQuery("from Question", Question.class);
        return query.getResultList();
    }
}
