package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.model.Student;

import java.util.List;

public interface EnrollmentDAO {
    List<Enrollment> get();
    List<Enrollment> getForStudent(int id);
    Enrollment get(int id);
}
