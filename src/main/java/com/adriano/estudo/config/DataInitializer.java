package com.adriano.estudo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.adriano.estudo.entity.User;
import com.adriano.estudo.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Iniciando dados...");
		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {
			createUser("Adriano", "wisintainer90@gmail.com");
			createUser("Paulo", "paulo@gmail.com");
			createUser("Maria", "maria@gmail.com");
		}

	}
	
	public void createUser(String name, String email) {
		User user = new User(name,email);
		userRepository.save(user);
	}

}
