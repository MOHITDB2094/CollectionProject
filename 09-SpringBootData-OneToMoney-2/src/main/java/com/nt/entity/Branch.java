package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "College_Branch")
public class Branch {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "branch_ID")
	private int bid;
	
	@Column(name = "branch_Name")
	private String bname;
}
