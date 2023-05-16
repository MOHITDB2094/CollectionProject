package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.ServiceClassMethod1;
import com.nt.service.ServiceClassMethod2;

@RestController
@RequestMapping("/report/csv")
public class ReportCSVController {

	@Autowired
	private ServiceClassMethod1 serviceClass;
	
	@Autowired
	private ServiceClassMethod2 serviceClass2;
	
	@PostMapping(path = "/1")
	public ResponseEntity<byte[]> downloadtoCSVmethod1(){
		return serviceClass.downloadCSV();
	}
	
	@PostMapping(path = "/2")
	public String downloadtoCSVmethod2(){
		return serviceClass2.downloadCSV("C:\\Users\\mohit\\OneDrive\\Desktop\\output1.csv");
	}
}
