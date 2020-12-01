package com.ice.icebox.controller;

import com.ice.icebox.entity.Student;
import com.ice.icebox.mapper.IceBoxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IceboxController {

    @Autowired
    IceBoxMapper mapper;

    @RequestMapping("/students")
    public @ResponseBody List<Student> getStudents() {

        return mapper.queryStudent();
    }

    @PostMapping("/new")
    public @ResponseBody String addStudent(@RequestParam String id,
                                           @RequestParam String name,
                                           @RequestParam Integer age) {

        final Student newStudent = Student.builder().id(id).name(name).age(age).build();
        return mapper.addStudent(newStudent) + " records were increased.";
    }
}
