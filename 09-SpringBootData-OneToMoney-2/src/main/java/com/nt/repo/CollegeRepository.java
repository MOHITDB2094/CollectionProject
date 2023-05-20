package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.College;

public interface CollegeRepository
				extends JpaRepository<College, Integer> {

}
