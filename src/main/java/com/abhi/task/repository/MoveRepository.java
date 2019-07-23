package com.abhi.task.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.domain.Game;
import com.abhi.task.domain.Move;
import com.abhi.task.domain.Player;


@Repository
public interface MoveRepository extends CrudRepository<Move , Long> {
	
	List<Move> findByGame(Game game);
	List<Move> findByGameTypeAndPlayer(Game game,Player palyer);
	int countByGameAndPlayer(Game game,Player player);
	
}
