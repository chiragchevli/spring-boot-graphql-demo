package com.graphqldemo.resolver;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqldemo.entity.PostEntity;
import com.graphqldemo.entity.UserEntity;
import com.graphqldemo.repositery.PostRepository;

@Component
public class UserResolver implements GraphQLResolver<UserEntity> {

	@Autowired
	private PostRepository postRepository;

//	public UserResolver(PostRepository postRepository) {
//		this.postRepository = postRepository;
//	}
	
	public Set<PostEntity> getPosts(UserEntity user)
	{
		//List<Long> postids = user.getPosts().stream().map(PostEntity::getId).collect(Collectors.toList());
		Set<PostEntity> postLiist = null;
		try {
			postLiist = postRepository.findByUserId(user.getId());			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return(postLiist);
	}
	
}
 