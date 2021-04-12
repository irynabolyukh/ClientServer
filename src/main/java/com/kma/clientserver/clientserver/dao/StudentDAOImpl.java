package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Student> query = currentSession.createQuery("from Student", Student.class);
        return query.getResultList();
    }

    @Override
    public Student get(int id) {
        return null;
    }
}
