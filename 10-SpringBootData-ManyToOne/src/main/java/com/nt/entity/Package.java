package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pkgId;
	
	@ManyToOne
	@JoinColumn(name = "Biscuit_Id_FK")
	private Biscuits biscuits;
}
