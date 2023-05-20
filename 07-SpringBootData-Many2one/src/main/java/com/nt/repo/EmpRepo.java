package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
