package com.ice.icebox.mapper;

import com.ice.icebox.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IceBoxMapper {

    @Select(" select * from student ")
    @Results({
            @Result(property = "id", column="id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    List<Student> queryStudent();

    @Insert("insert into student values (#{student.id}, #{student.name}, #{student.age})")
    int addStudent(@Param("student") Student student);
}
