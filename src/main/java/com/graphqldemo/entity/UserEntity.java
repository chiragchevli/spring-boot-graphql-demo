package com.graphqldemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

		
	public UserEntity(String name) {		
		this.name = name;
	}	
	
	public UserEntity(Long id) {		
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;
	
	public UserEntity() {
		
	}

}