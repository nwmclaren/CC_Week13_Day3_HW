package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> getWhiskyFromYear(int year){
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            result = cr.list();
        } catch(HibernateException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Transactional
    public List<Whisky> getWhiskyFromDistilleryByAge(String distillery, int age){

        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryName");
            cr.add(Restrictions.eq("distilleryName.name", distillery));
            cr.add((Restrictions.eq("age", age)));
            result = cr.list();


        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return  result;


    }

    @Transactional
    public List <Whisky> getWhiskyFromRegion(String region){

        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryRegion");
            cr.add(Restrictions.eq("distilleryRegion.region", region));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;

    }

}
