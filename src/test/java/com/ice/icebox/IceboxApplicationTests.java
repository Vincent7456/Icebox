package com.ice.icebox;

import com.ice.icebox.controller.IceboxController;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(IceboxController.class)
@AutoConfigureMybatis
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED)
class IceboxApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void listAll() throws Exception {

		ResultActions resultActions = this.mvc.perform(
				MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print());
	}

	@Test
	void newStudent() throws Exception {

		ResultActions resultActions = this.mvc.perform(
				MockMvcRequestBuilders.post("/new").accept(MediaType.APPLICATION_JSON)
						.param("id", "3")
						.param("name", "Test")
						.param("age", "35"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
		resultActions.andDo(MockMvcResultHandlers.print());
	}

}
