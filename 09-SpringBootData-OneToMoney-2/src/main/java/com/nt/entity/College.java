package com.nt.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "College")
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "College_Code")
	private int cid;
	
	@Column(name = "College_Name")
	private String cname;
	
	@OneToMany
	@JoinColumn(name = "branch_ID_FK")
	private List<Branch> blist;
}
