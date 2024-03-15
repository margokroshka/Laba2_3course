package com.example.demolaba2.repository;

import com.example.demolaba2.dto.Predmet;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class PrepodRepository {
    private SessionFactory sessionFactory;

    public PrepodRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Transactional
    public List getPrepodNotInThisDay(String day_of_week) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session.createQuery("from Prepod t where t.id not in " +
                        "(select l.prepod.id from Predmet l where l.day_of_week =: day_of_week)")
                .setParameter("day_of_week", day_of_week)
                .getResultList();
    }

    @Transactional
    public List<Predmet> getPrepodDayClassroom(String day_of_week, Integer number_class) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Predmet where" +
                        " day_of_week =: day_of_week and number_class =: number_class", Predmet.class)
                .setParameter("day_of_week", day_of_week)
                .setParameter("number_class", number_class)
                .getResultList();
    }


}
