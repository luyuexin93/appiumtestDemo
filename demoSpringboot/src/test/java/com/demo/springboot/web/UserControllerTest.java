package com.demo.springboot.web;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author 作者 luyuexin:
 * @version 创建时间：2020年3月31日 下午9:46:32 类说明
 *          //Junit4写法 @RunWith(SpringRunner.class)
 */
@ExtendWith(SpringExtension.class)

@SpringBootTest
public class UserControllerTest {
	private MockMvc mvc;

	@BeforeEach
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}

	@Test
	public void testUserController() throws Exception {
		RequestBuilder request;

		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}
}
