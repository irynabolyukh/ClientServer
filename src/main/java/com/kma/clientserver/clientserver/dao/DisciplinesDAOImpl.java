package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Disciplines;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DisciplinesDAOImpl implements DisciplinesDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Disciplines> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Disciplines> query = currentSession.createQuery("from Disciplines", Disciplines.class);
        return query.getResultList();
    }

    @Override
    public Disciplines get(int id) {
        return null;
    }
}
