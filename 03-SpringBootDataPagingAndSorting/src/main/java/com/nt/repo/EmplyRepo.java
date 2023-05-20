package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface EmplyRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByIdLessThanEqual(Integer id);
	List<Employee> findByEaddOrderByEnameDesc(String eadd);
}
