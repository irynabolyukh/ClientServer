package com.kma.clientserver.clientserver.controller;

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
    public List<Student> get(){
        return studentService.get();
    }

    @PostMapping("/students/{id}")
    public Student get(@PathVariable(name = "id") String id) {
        Student studentObj = studentService.get(Integer.parseInt(id));
        if(studentObj == null) {
            throw new RuntimeException("Student not found for the Id:"+id);
        }
        return studentObj;
    }
}
