package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Package;

public interface PackageRepo extends JpaRepository<Package, Integer> {

}
