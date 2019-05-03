package com.graphqldemo.repositery;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.graphqldemo.entity.UserEntity;


@Repository
public interface UserRepository  extends CrudRepository<UserEntity, Long>{
	
}

