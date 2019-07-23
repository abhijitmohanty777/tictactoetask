package com.abhi.task.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhi.task.DTO.PlayerDTO;
import com.abhi.task.domain.Player;
import com.abhi.task.repository.PlayerRepository;
import com.abhi.task.security.ContextUser;

@Service
@Transactional
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
	
	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public Player CreateNewPlayer(PlayerDTO playerdto){
		Player newPlayer=new Player();
		newPlayer.setUserName(playerdto.getUserName());
		newPlayer.setPassword(passwordEncoder.encode(playerdto.getPassword()));
		newPlayer.setEmail(playerdto.getEmail());
		playerRepository.save(newPlayer);
		return newPlayer;
	}
	
	public Player getLoggedUser() {
		ContextUser principal=(ContextUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return playerRepository.findOneByUserName(principal.getPlayer().getUserName());
		
	}
	public List<Player> listplayer(){
		List<Player> players=(List<Player>) playerRepository.findAll();
		return players;
		
	}
	
}
