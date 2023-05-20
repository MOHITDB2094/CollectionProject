package com.nt.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.repo.EmplyRepo;
@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private EmplyRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.findAll().forEach(System.out::println);
		 
		System.out.println("\n \n \n -----------------------------");
		
		repo.findByIdLessThanEqual(5).forEach(System.out::println);
		System.out.println("\n \n  -----------------------------");
		repo.findByEaddOrderByEnameDesc("Kuradhi").forEach(System.out::println);
		System.out.println("\n \n  -----------------------------");
		//input
				Pageable p = PageRequest.of(2, 2);
				
				//output
				Page<Employee> page = repo.findAll(p);
				
				//result
				page.getContent()//List<T>
				.forEach(System.out::println);
				
				//metadata
				System.out.println(page.isFirst());
				System.out.println(page.isLast());
				System.out.println(page.isEmpty());
				System.out.println(page.hasNext());
				System.out.println(page.hasPrevious());
				System.out.println(page.getTotalPages());
				System.out.println(page.getTotalElements());
				System.out.println(page.getSize());
				System.out.println(page.hasContent());
	}

}
