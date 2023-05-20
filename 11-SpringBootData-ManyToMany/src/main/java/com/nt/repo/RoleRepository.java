package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

}
