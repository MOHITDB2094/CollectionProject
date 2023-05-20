package com.nt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	private int eid;
	
	private String ename;
	
	private String eadd;
	
	@ManyToMany
	@JoinTable(
			name =  "EmpRole",
			joinColumns = @JoinColumn(name = "eidFK"),
			inverseJoinColumns = @JoinColumn(name = "roleFK")
			)
	private List<Roles> roleList;
	
}
