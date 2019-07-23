package com.abhi.task.service;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.abhi.task.domain.Game;
import com.abhi.task.domain.Position;

public class GameLogic {
	
	private final Game game;

	public GameLogic(Game game) {
		
		this.game = game;
	}
	
	static Boolean isWinner(List<Position> positions) {
		return getWinningPositions().stream().anyMatch(positions::containsAll);
		
	}

	static List<List<Position>> getWinningPositions() {
		List<List<Position>> winningPositions=new ArrayList<>();
		
		winningPositions.add(asList(new Position(1,1), new Position(1,2), new Position(1,3)));
		winningPositions.add(asList(new Position(2,1), new Position(2,2), new Position(2,3)));
		winningPositions.add(asList(new Position(3,1), new Position(3,2), new Position(3,3)));
		
		winningPositions.add(asList(new Position(1,1), new Position(2,1), new Position(3,1)));
		winningPositions.add(asList(new Position(1,2), new Position(2,2), new Position(3,2)));
		winningPositions.add(asList(new Position(1,3), new Position(2,3), new Position(3,3)));

		winningPositions.add(asList(new Position(1, 1), new Position(2, 2), new Position(3,3)));
		winningPositions.add(asList(new Position(3, 1), new Position(2, 2), new Position(1,3)));

		return winningPositions;
	}
	
	static List<Position> getAllPosition(){
		List<Position> positions = new ArrayList<>();
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                positions.add(new Position(row, col));
            }
        }
        return positions;
	}
	
	static boolean playerTurn(int numberOfFirstPlayerMovesInGame, int numberOfSecondPlayerMovesInGame) {
        return numberOfFirstPlayerMovesInGame == numberOfSecondPlayerMovesInGame || numberOfFirstPlayerMovesInGame == 0;
    }

    static boolean isBoardIsFull(List<Position> takenPositions) {
        return takenPositions.size() == 9;
    }

    
    static List<Position> getOpenPositions(List<Position> takenPositions) {
        return getAllPosition().stream().filter(p -> !takenPositions.contains(p)).collect(Collectors.toList());
   }

    static Position nextAutoMove(List<Position> takenPositions) {
        return getOpenPositions(takenPositions).get(0);
   }

	
}
