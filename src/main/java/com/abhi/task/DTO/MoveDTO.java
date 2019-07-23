package com.abhi.task.DTO;

import java.util.Date;

import com.abhi.task.enums.GameStatus;
import com.abhi.task.enums.GameType;
import com.abhi.task.enums.Piece;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoveDTO {
	private int boardRow;
	private int boardColumn;
	private Date created;
	private String userName;
	private GameStatus gameStatus;
	private Piece playerPieceCode;
}
