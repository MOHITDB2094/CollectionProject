package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.entity.Member;
import com.nt.repo.DeptRepo;
import com.nt.repo.EmpRepo;
import com.nt.repo.MemberRepo;
@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	DeptRepo deptrepo;
	
	@Autowired
	EmpRepo emprepo;
	
	@Autowired
	MemberRepo mrepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Department  dept = new Department();
		dept.setDept("Devlopers");
		deptrepo.save(dept);
		
		/*Employee emp = new Employee();
		emp.setEname("Manny");
		emp.setEadd("hyd");
		emp.setDept(dept);
		emprepo.save(emp);
		*/
		
		Member mem = new Member();
		mem.setDept(dept);
		mem.setName("Mohit");
		
		mrepo.save(mem);
		

	}

}
