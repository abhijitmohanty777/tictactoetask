package com.abhi.task.DTO;

import com.abhi.task.enums.GameType;
import com.abhi.task.enums.Piece;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
	private int id;
	private GameType gameType;
	private Piece piece;
	

}
