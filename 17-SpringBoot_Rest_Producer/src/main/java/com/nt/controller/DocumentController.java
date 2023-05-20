package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Document;

@RestController
@RequestMapping("/doc")
public class DocumentController {

	
	@GetMapping("/showA")
	public String showA() {
		return "This is the Producer First Call";
	}
	
	@GetMapping("/showB/{id}/{name}")
	public ResponseEntity<String> showB(@PathVariable Integer id, @PathVariable String name){
		
		return new ResponseEntity<String>("This is the second call "+ id+"  "+ name, HttpStatus.CREATED);
	}
	
	@GetMapping("/showC")
	public ResponseEntity<Document> showC(Integer id, String docType, String docExtension){
		return new ResponseEntity<Document>(new Document(id, docType, docExtension), HttpStatus.CREATED);
	}
}
