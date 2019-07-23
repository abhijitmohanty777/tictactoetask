package com.abhi.task.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.domain.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Long>{
	
	Player findOneByUserName(String userName);
}
