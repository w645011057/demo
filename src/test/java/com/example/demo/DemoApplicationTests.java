package com.example.demo;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static  org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 测试类
 */
//引入Spring对JUnit4的支持
@RunWith(SpringJUnit4ClassRunner.class)
//
@ContextConfiguration
//开启Web应用的配置，用于模拟ServletContext
@WebAppConfiguration
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class DemoApplicationTests {
	/**
	 * 用于模拟调用Controller的接口发起请求，在@text定义的hello测试用例中，perform函数执行一次请求调用，accept用于
	 * 执行接受的数据类型，andExpect 用于判断接口返还的期望值。
	 */
	private MockMvc mvc;
	@Autowired
	private WebApplicationContext webApplicationContext;

	/**
	 * JUnit中定义在测试用例@Text内容执行前预加载的内容，这里用来初始化MockMvc
	 * @throws Exception
	 */
	@Before
	public void setUp() throws  Exception{
		mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	@Test
	public void contextLoads() throws  Exception {
		mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/hello")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

}
