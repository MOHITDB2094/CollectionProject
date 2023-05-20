package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Biscuits;

public interface BiscuitRepo extends JpaRepository<Biscuits, Integer> {

}
