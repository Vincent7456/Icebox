package com.ice.icebox.controller;

import com.ice.icebox.config.IceboxConfiguration;
import com.ice.icebox.entity.Student;
import com.ice.icebox.service.IceboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IceboxController {

    @Autowired
    private IceboxService service;

    @Autowired
    private IceboxConfiguration config;

    @RequestMapping("/students")
    public @ResponseBody List<Student> getStudents() {

        config.print();
        return service.listAll();
    }

    @PostMapping("/new")
    public @ResponseBody String addStudent(@RequestParam String id,
                                           @RequestParam String name,
                                           @RequestParam Integer age) {

        return service.createStudent(id, name, age) + " records were increased.";
    }
}
