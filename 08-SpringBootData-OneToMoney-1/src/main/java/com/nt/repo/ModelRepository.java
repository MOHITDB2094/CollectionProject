package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}