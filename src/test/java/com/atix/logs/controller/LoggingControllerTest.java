package com.atix.logs.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atix.logs.models.LogBody;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LoggingControllerTest {

	@Autowired
	LoggingController logginController;
	
	
	@Test
	void createLogMessageTest() {
		LogBody body = new LogBody();
		body.setMessage("Hola mundo");
		assertNotNull(logginController.createLogMessage(body).getBody());
		assertEquals(logginController.createLogMessage(body).getBody().getMessage(), "Hola mundo");		
	}

}
