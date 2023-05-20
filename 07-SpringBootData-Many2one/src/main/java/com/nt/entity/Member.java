package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "memberId")
	private int mid;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name = "didFK")
	private Department dept;
	
}
