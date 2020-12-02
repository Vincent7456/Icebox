package com.ice.icebox.service;

import com.ice.icebox.entity.Student;
import com.ice.icebox.mapper.IceBoxMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@WebMvcTest(IceboxService.class)
public class IceboxServiceTests {

    @Autowired
    private IceboxService service;

    @MockBean
    private IceBoxMapper mapper;

    @Test
    public void listAll() {
        Mockito.when(this.mapper.queryStudent())
                .thenReturn(Arrays.asList(Student.builder().id("1").name("Mock Service").age(22).build()));
        this.service.listAll().forEach(item -> System.out.println(item));
    }
}
