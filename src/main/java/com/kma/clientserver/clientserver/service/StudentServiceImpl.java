package com.kma.clientserver.clientserver.service;

import com.kma.clientserver.clientserver.dao.StudentDAO;
import com.kma.clientserver.clientserver.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Transactional
    @Override
    public List<Student> get() {
        return studentDAO.get();
    }

    @Transactional
    @Override
    public Student get(int id) {
        return studentDAO.get(id);
    }
}
