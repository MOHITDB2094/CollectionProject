package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BootCustomeExceptionHandler {

	@ExceptionHandler(ZanduException.class)
	public ResponseEntity<String>  zanduException(ZanduException zanduException){
		return new ResponseEntity<String>(zanduException.getMessage(), HttpStatus.BAD_GATEWAY);
	}
}
