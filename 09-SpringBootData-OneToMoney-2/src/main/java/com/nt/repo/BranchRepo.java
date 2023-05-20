package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Branch;

public interface BranchRepo 
					extends JpaRepository<Branch, Integer> {

}
