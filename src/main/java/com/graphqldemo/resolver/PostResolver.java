package com.graphqldemo.resolver;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqldemo.entity.PostEntity;
import com.graphqldemo.entity.UserEntity;
import com.graphqldemo.repositery.UserRepository;

@Component
public class PostResolver implements GraphQLResolver<PostEntity> {

	private UserRepository userRepository;

	public PostResolver(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserEntity getUser(PostEntity post)
	{
		Optional<UserEntity> tempuser = null;
		try {
			tempuser = userRepository.findById(post.getUser().getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(tempuser.isPresent()) {
			return tempuser.get();
		}
		return(null);
	}
}
 