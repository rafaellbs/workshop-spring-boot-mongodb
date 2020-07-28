package com.rafaellima.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafaellima.workshopmongo.domain.User;
import com.rafaellima.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiaion implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User maria= new User(null, "Maria Eduarda", "maria@gmail.com");
		User alex= new User(null, "Alex Gomes", "alex@gmail.com");
		User bruno= new User(null, "Bruno Silva", "bruno@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bruno));
	}
	

}
