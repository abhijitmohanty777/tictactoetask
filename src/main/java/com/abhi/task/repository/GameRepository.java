package com.abhi.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.domain.Game;
import com.abhi.task.enums.GameStatus;
import com.abhi.task.enums.GameType;



@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	
	List<Game> findByGameTypeAndGameStatus(GameType gameType , GameStatus gameStatus);
	List<Game> findByGameStatus(GameStatus gameStatus);
	

}
