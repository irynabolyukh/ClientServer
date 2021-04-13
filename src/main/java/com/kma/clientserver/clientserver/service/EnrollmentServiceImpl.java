package com.kma.clientserver.clientserver.service;

import com.kma.clientserver.clientserver.dao.EnrollmentDAO;
import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentDAO enrollmentDAO;

    @Transactional
    @Override
    public List<Enrollment> get() {
        return enrollmentDAO.get();
    }

    @Transactional
    @Override
    public List<Enrollment> getForStudent(int id) {
        return enrollmentDAO.getForStudent(id);
    }

    @Transactional
    @Override
    public Enrollment get(int id) {
        return enrollmentDAO.get(id);
    }
}
