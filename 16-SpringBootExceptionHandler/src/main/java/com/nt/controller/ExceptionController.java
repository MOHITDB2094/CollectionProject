package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.exception.ZanduException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ext")
public class ExceptionController {

	@GetMapping("/status/{id}")
	public ResponseEntity<String> getStatus(@PathVariable Integer id){
		String message = String.format("Method entered with id %s", id);
		log.info(message);
		if (id >= 100) {
			message = String.format("Method successful with id %s", id);
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			throw new ZanduException("ZAndu Time");
		}
	}
}
