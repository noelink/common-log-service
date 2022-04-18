package com.atix.logs.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atix.logs.models.LogBoby;
import com.atix.logs.utils.ShaUtils;

@RestController
public class LoggingController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(LoggingController.class);
	
	@PostMapping("managed-logs")
    public ResponseEntity<LogBoby> createLogMessage(@RequestBody LogBoby logBody) {
		logBody.setCreationDate(LocalDateTime.now());
		logBody.setPrev_hash(ShaUtils.generateRandomLineHash());
		StringBuilder nonceBuilder = new StringBuilder();
		nonceBuilder.append(logBody.getPrev_hash()).append(logBody.getMessage()).append(Optional.ofNullable(logBody.getNonce()).orElse("00"));
		logBody.setNonce(ShaUtils.getSHAKey(nonceBuilder));
		LOGGER.info("{} {} {}",logBody.getPrev_hash(),logBody.getMessage(),logBody.getNonce());
        return new ResponseEntity<>(logBody, HttpStatus.OK);
    }

}
