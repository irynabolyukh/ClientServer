package com.kma.clientserver.clientserver.dao;

import com.kma.clientserver.clientserver.model.Enrollment;

import java.util.List;

public interface EnrollmentDAO {
    List<Enrollment> get();
    Enrollment get(int id);
}
