package com.example.cdshop;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.cdshop.web.CdController;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CdshopApplicationTests {
	
	@Autowired
	private CdController controller;

	@Test
	public void contextLoads()  throws Exception{
		assertThat(controller).isNotNull();
	}

}
