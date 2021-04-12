package com.kma.clientserver.clientserver.service;

import com.kma.clientserver.clientserver.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> get();
    Student get(int id);
}
