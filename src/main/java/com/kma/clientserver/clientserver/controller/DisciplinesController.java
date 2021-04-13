package com.kma.clientserver.clientserver.controller;

import com.kma.clientserver.clientserver.model.Disciplines;
import com.kma.clientserver.clientserver.service.DisciplinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DisciplinesController {

    @Autowired
    private DisciplinesService disciplinesService;

    @GetMapping("/disciplines")
    @ResponseBody
    public List<Disciplines> get(){
        return disciplinesService.get();
    }

    @GetMapping("/disciplines/{id}")
    @ResponseBody
    public Disciplines get(@PathVariable int id) {
        Disciplines disciplinesObj = disciplinesService.get(id);
        if(disciplinesObj == null) {
            throw new RuntimeException("Discipline not found for the Id:"+id);
        }
        return disciplinesObj;
    }
}
