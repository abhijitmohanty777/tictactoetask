package com.abhi.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.abhi.task.domain.Player;
import com.abhi.task.repository.PlayerRepository;

@SpringBootApplication
public class TictactoegameApplication {

	public static void main(String[] args) {
		SpringApplication.run(TictactoegameApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PlayerRepository  playerRepository){
		return (args) -> {

            //save a couple of players
            playerRepository.save(new Player("abhi", "abhi@abhi.com", new BCryptPasswordEncoder().encode("abhi")));
            playerRepository.save(new Player("jit", "jit@jit.com",  new BCryptPasswordEncoder().encode("jit")));
            
            
        };
	}
}
