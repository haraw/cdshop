package com.example.cdshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.cdshop.domain.Cd;
import com.example.cdshop.domain.CdRepository;
import com.example.cdshop.domain.Genre;
import com.example.cdshop.domain.GenreRepository;
import com.example.cdshop.domain.UserRepository;
import com.example.cdshop.domain.User;

@SpringBootApplication
public class CdshopApplication {
		
	private static final Logger Log = LoggerFactory.getLogger(CdshopApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CdshopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CdRepository cdrepository, GenreRepository genrerepository, UserRepository userrepository) {
		return (args) -> {
			Log.info("Saving CDs");
			
			genrerepository.save(new Genre("Prog"));
			genrerepository.save(new Genre("Rock"));
			genrerepository.save(new Genre("Pop"));
			
			cdrepository.save(new Cd("Fragile", "Yes", 1971, 19.90, genrerepository.findByName("Prog").get(0)));
			cdrepository.save(new Cd("Rising", "Rainbow", 1976, 15.90, genrerepository.findByName("Rock").get(0)));
			cdrepository.save(new Cd("She Wolf", "Shakira", 2009, 1.90, genrerepository.findByName("Pop").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
		};
	}

}
