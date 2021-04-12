package com.kma.clientserver.clientserver.controller;

import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public List<Enrollment> get(){
        return enrollmentService.get();
    }

    @GetMapping("/enrollments/{id}")
    public Enrollment get(@PathVariable int id) {
        Enrollment enrollmentObj = enrollmentService.get(id);
        if(enrollmentObj == null) {
            throw new RuntimeException("Enrollment not found for the Id:"+id);
        }
        return enrollmentObj;
    }
}
