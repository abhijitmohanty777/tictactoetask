package com.abhi.task.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhi.task.DTO.GameDTO;
import com.abhi.task.domain.Game;
import com.abhi.task.domain.Player;
import com.abhi.task.enums.GameStatus;
import com.abhi.task.enums.GameType;
import com.abhi.task.repository.GameRepository;


@Service
@Transactional
public class GameService {

	private final GameRepository gameRepository;


    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createNewGame(Player player, GameDTO gameDTO) {
        Game game = new Game();
        game.setFirstPlayer(player);
        game.setGameType(gameDTO.getGameType());
        game.setFirstPlayerPieceCode(gameDTO.getPiece());
        game.setGameStatus(gameDTO.getGameType() == GameType.COMPUTER ? GameStatus.IN_PROGRESS :
                GameStatus.WAITS_FOR_PLAYER);

        game.setCreated(new Date());
        gameRepository.save(game);

        return game;
    }


    public Game updateGameStatus(Game game, GameStatus gameStatus) {
        Game g = getGame(game.getId());
        g.setGameStatus(gameStatus);

        return g;
    }

    public List<Game> getGamesToJoin(Player player) {
        return gameRepository.findByGameTypeAndGameStatus(GameType.COMPITITION,
                GameStatus.WAITS_FOR_PLAYER).stream().filter(game -> game.getFirstPlayer() != player).collect(Collectors.toList());

    }

    public Game joinGame(Player player, GameDTO gameDTO) {
        Game game =  getGame((long) gameDTO.getId());
        game.setSecondPlayer(player);
        gameRepository.save(game);

        updateGameStatus(game, GameStatus.IN_PROGRESS);

        return game;

    }

    public List<Game> getPlayerGames(Player player) {
        return gameRepository.findByGameStatus(
                GameStatus.IN_PROGRESS).stream().filter(game -> game.getFirstPlayer() == player).collect(Collectors.toList());
    }


    public Game getGame(Long id) {
        return gameRepository.findOne(id);
    }

}
