package com.graphqldemo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphqldemo.entity.PostEntity;
import com.graphqldemo.entity.UserEntity;
import com.graphqldemo.repositery.PostRepository;
import com.graphqldemo.repositery.UserRepository;

@Component
public class Mutation implements GraphQLMutationResolver  {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	public PostEntity newPost(String text, String imageUrl,Long userId) {		
		PostEntity postEntity = new PostEntity(text, imageUrl, new UserEntity(userId));
		postRepository.save(postEntity);
		return(postEntity);
	}
	
	public boolean deletePost(Long id) {
			postRepository.deleteById(id);
			return(true);
	}
	
	public PostEntity updatePostText(Long id, String text) {
		PostEntity post = postRepository.findById(id).get();
		post.setText(text);
		postRepository.save(post);
		return(post);
	}
	
	public UserEntity newUser(String name) {
		UserEntity user = new UserEntity(name);
		userRepository.save(user);
		return(user);
	}
	
	public boolean deleteUser(Long id) {
		userRepository.deleteById(id);
		return(true);
	}
	
	public UserEntity updateUserName(Long id, String name) {
		UserEntity user = userRepository.findById(id).get();
		user.setName(name);
		userRepository.save(user);
		return(user);
	}
}
















