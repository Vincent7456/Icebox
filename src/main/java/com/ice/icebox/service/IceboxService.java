package com.ice.icebox.service;

import com.ice.icebox.entity.Student;
import com.ice.icebox.mapper.IceBoxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IceboxService {

    @Autowired
    IceBoxMapper mapper;

    public List<Student> listAll() {

        return mapper.queryStudent();
    }

    public String createStudent(String id, String name, Integer age) {

        final Student newStudent = Student.builder().id(id).name(name).age(age).build();
        return mapper.addStudent(newStudent) + " records were increased.";
    }

}
