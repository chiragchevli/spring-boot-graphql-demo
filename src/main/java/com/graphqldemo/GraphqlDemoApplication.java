package com.graphqldemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphqldemo.entity.PostEntity;
import com.graphqldemo.entity.UserEntity;
import com.graphqldemo.repositery.PostRepository;
import com.graphqldemo.repositery.UserRepository;

@SpringBootApplication
public class GraphqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PostRepository postRepository, UserRepository userRepository) {
		return args -> {
			UserEntity user = new UserEntity("chirag");			
			userRepository.save(user);
			user = new UserEntity("viral");
			userRepository.save(user);
			PostEntity post = new PostEntity("post1", "url",userRepository.findById(1l).get());
			postRepository.save(post);
			post = new PostEntity("post2", "url2",userRepository.findById(2l).get());
			postRepository.save(post);
		};
	}
}
