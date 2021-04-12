package com.kma.clientserver.clientserver.controller;

import com.kma.clientserver.clientserver.model.Student;
import com.kma.clientserver.clientserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> get(){
        return studentService.get();
    }

    @GetMapping("/students/{id}")
    public Student get(@PathVariable int id) {
        Student studentObj = studentService.get(id);
        if(studentObj == null) {
            throw new RuntimeException("Student not found for the Id:"+id);
        }
        return studentObj;
    }
}
