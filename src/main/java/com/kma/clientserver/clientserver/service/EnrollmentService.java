package com.kma.clientserver.clientserver.service;

import com.kma.clientserver.clientserver.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> get();
    List<Enrollment> getForStudent(int id);
    Enrollment get(int id);
}
