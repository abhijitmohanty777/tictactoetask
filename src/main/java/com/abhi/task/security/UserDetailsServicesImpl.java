package com.abhi.task.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.springframework.util.StringUtils.isEmpty;

import com.abhi.task.domain.Player;
import com.abhi.task.repository.PlayerRepository;

@Component
public class UserDetailsServicesImpl implements UserDetailsService {
	
	private final PlayerRepository playerRepository;
	
	
	@Autowired
	public UserDetailsServicesImpl(PlayerRepository playerRepository) {
		
		this.playerRepository = playerRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		checkNotNull(username);
		
		if(isEmpty(username)) {
			throw new UsernameNotFoundException("User Name Cannot be Empty");
		}
		Player player=playerRepository.findOneByUserName(username);
		if(player == null) {
			throw new UsernameNotFoundException("Player"+username+"doesn't exist");
		}
		
		return new ContextUser(player);
	}


}
