package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> get();
    Student get(int id);
    List<Enrollment> getEnrollmentsForStudent(int id);
}
