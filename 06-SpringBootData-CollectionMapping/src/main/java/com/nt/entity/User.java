package com.nt.entity;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;
	@Column(name="user")
	private String username;
	
	@ElementCollection
	@CollectionTable(
			name = "User_Role",
			joinColumns = @JoinColumn(name ="uidFK")
			)
	private List<String> roles;
	
	@ElementCollection
	@CollectionTable(
			name= "User_Access_Role",
			joinColumns = @JoinColumn(name="uidFK")
			)
	private Map<Integer, String> roleAccess;
	
	
}
