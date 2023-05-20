package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {

}
