package com.kma.clientserver.clientserver.controller;

import com.kma.clientserver.clientserver.model.Enrollment;
import com.kma.clientserver.clientserver.model.Student;
import com.kma.clientserver.clientserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    @ResponseBody
    public List<Student> get(){
        return studentService.get();
    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student get(@PathVariable int id) {
        Student studentObj = studentService.get(id);
        if(studentObj == null) {
            throw new RuntimeException("Student not found for the Id:"+id);
        }
        return studentObj;
    }

    @GetMapping("/students/enrollments/{id}")
    @ResponseBody
    public List<Enrollment> getEnrollmentsForStudent(@PathVariable int id) {
        List<Enrollment> enrollments = studentService.getEnrollmentsForStudent(id);
        if(enrollments == null) {
            throw new RuntimeException("Enrollments were not found!");
        }
        return enrollments;
    }
}
