package com.graphqldemo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqldemo.entity.PostEntity;
import com.graphqldemo.entity.UserEntity;
import com.graphqldemo.repositery.PostRepository;
import com.graphqldemo.repositery.UserRepository;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	public Iterable<UserEntity> findAllUser() {
		return (userRepository.findAll());
	}
	
	public long countUsers() {
		return(userRepository.count());
	}
	
	public UserEntity findUserFromPost(long postid) {
		return(userRepository.findById(postRepository.findById(postid).get().getUser().getId()).get());
	}
	
	public UserEntity findUser(long userid) {
		return(userRepository.findById(userid).get());
	}
	
	public Iterable<PostEntity> findAllPost() {
		return (postRepository.findAll());
	}
	
	public long countPost() {
		return(postRepository.count());
	}
	
	public PostEntity findPost(long postid) {
		return(postRepository.findById(postid).get());
	}
	
	public long countPostOfUser(long userid) {
		return(postRepository.findByUserId(userid).size());
	}
	
	public Iterable<PostEntity> findAllPostOfUser(long userid) {
		
		try { 
			return(postRepository.findByUserId(userid));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return(null);
		
		
	}
	
	

}















