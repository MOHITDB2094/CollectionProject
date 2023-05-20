package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Biscuits {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer biscId;
	
	private String bscName;
	
	private int biscNumber;
}
