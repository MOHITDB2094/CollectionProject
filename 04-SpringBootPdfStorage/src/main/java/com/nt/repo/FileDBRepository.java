package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.FileDB;
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
