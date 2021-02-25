package vbsolutions.com.br.DesafioAppus;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import vbsolutions.com.br.DesafioAppus.controllers.VendedorController;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class DesafioAppusApplicationTests {

	@Autowired
	private VendedorController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
//	@Test
//	public void greetingShouldReturnDefaultMessage() throws Exception {
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//				String.class)).contains("Hello, World");
//	}

}
