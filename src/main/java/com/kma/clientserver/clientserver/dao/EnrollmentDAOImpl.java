package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Enrollment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EnrollmentDAOImpl implements EnrollmentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Enrollment> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Enrollment> query = currentSession.createQuery("from Enrollment", Enrollment.class);
        return query.getResultList();
    }

    @Override
    public Enrollment get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Enrollment.class, id);
    }
}
