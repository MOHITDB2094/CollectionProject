package com.nt.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.entity.Document;

@Component
public class GetTestRunner implements CommandLineRunner {

	
	@Value("prod.showA")
	String showA;
	@Value("prod.showB")
	String showB;
	@Value("prod.showC")
	String showC;
	
	@Override
	public void run(String... args) throws Exception {
		
		String url1 = "http://localhost:9090/doc/showA";
		String url2 = "http://localhost:9090/doc/showB/{id}/{name}";
		String url3 =  "http://localhost:9090/doc/showC";
		
		//2. Create Request Headers
		//3. Create Request Body
		
		//4. Create RestTemplate object
		RestTemplate template = new RestTemplate();
		
		//Make HTTP call and GET Response back
		//ResponseEntity<String> response = template.getForEntity(url2, String.class,120,"ANBC");
		//ResponseEntity<String> response = template.getForEntity(url1, String.class);
		ResponseEntity<Document> response = template.getForEntity(url3, Document.class,101,"word",".docx");
		
		//print details
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());

	}

}
