package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
