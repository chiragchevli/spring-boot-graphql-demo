package com.graphqldemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "post")
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String text;

	@Column
	private String imageUrl;

	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	public PostEntity(String text, String imageUrl, UserEntity user) {
		this.text = text;
		this.imageUrl = imageUrl;
		this.user = user;
	}

	public PostEntity( ) {
		
	}
	
}