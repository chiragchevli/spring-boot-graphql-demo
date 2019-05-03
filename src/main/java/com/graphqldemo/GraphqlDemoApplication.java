package com.graphqldemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graphqldemo.entity.PostEntity;
import com.graphqldemo.entity.UserEntity;
import com.graphqldemo.error.GraphQLErrorAdapter;
import com.graphqldemo.repositery.PostRepository;
import com.graphqldemo.repositery.UserRepository;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

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
	
	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}
}


