package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.entity.Roles;
import com.nt.repo.EmployeeRepository;
import com.nt.repo.RoleRepository;
@Component
public class TestDataRunner implements CommandLineRunner{

	@Autowired
	RoleRepository rolrepo;
	
	@Autowired
	EmployeeRepository erepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Roles r1 = new Roles(1, "Developer");
		Roles r2 = new Roles(2, "Tester");
		Roles r3 = new Roles(3, "DataScientist");
		Roles r4 = new Roles(4, "DevOps");
	
		Employee emp1 = new Employee(101, "Maddy", "HYD", Arrays.asList(r1,r3,r4));
		Employee emp2 = new Employee(102, "Govinda", "HYD", Arrays.asList(r2,r4));
		
		rolrepo.save(r1);
		rolrepo.save(r2);
		rolrepo.save(r3);
		rolrepo.save(r4);
		
		erepo.save(emp1);
		erepo.save(emp2);
		
		
	}

}
