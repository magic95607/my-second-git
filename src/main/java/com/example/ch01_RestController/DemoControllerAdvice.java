package com.example.ch01_RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> exceptionHandler(RuntimeException e){
		System.out.println("runtimeException:"+ e.getMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("runtimeException:"+ e.getMessage());
		
	}
}
