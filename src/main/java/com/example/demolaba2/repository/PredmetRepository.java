package com.example.demolaba2.repository;
import com.example.demolaba2.dto.Predmet;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PredmetRepository {
    private SessionFactory sessionFactory;

    public PredmetRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }




    @Transactional
    public List getDayOfWeekInDayClassesAmount(Integer classesAmount) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Predmet group by day_of_week having count(*) =: classesAmount")
                .setParameter("classesAmount", classesAmount).getResultList();
    }


    @Transactional
    public List getDayOfWeekInDayClassroomsAmount(Integer classroomsAmount) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Predmet group by day_of_week having count(distinct number_class) =: classroomsAmount")
                .setParameter("classroomsAmount", classroomsAmount).getResultList();
    }
}
