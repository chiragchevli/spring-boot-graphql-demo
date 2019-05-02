package com.graphqldemo.repositery;


import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.graphqldemo.entity.PostEntity;


@Repository
public interface PostRepository  extends CrudRepository<PostEntity, Long>{
	
	public Optional<PostEntity> findByIdAndUserId(Long id, Long userId);
	public Set<PostEntity> findByUserId(Long userId);
	
}

