package com.rafaellima.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rafaellima.workshopmongo.domain.Post;
import com.rafaellima.workshopmongo.domain.User;
import com.rafaellima.workshopmongo.dto.AuthorDTO;
import com.rafaellima.workshopmongo.dto.CommentDTO;
import com.rafaellima.workshopmongo.repository.PostRepository;
import com.rafaellima.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiaion implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria= new User(null, "Maria Eduarda", "maria@gmail.com");
		User alex= new User(null, "Alex Gomes", "alex@gmail.com");
		User bruno= new User(null, "Bruno Silva", "bruno@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bruno));
		
		Post post1 = new Post(null, sdf.parse("27/07/2020"),"Partiu Viagem","Vou viajar para SP, abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("29/07/2020"),"Bom dia","Acordei feliz!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("27/07/2020"),new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("28/07/2020"), new AuthorDTO(bruno));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("29/07/2020"),new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
	

}
