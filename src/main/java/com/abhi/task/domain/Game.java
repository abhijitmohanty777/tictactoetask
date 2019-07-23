package com.abhi.task.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Entity;

import com.abhi.task.enums.GameStatus;
import com.abhi.task.enums.GameType;
import com.abhi.task.enums.Piece;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Check(constraints = "first_player_piece_code = 'O' or first_player_piece_code = 'X' " +
        "and game_type = 'COMPUTER' or game_type = 'COMPETITION' " +
        "and game_status = 'IN_PROGRESS' or game_status = 'FIRST_PLAYER_WON' or game_status = 'SECOND_PLAYER_WON'" +
        "or game_status = 'TIE' or game_status = 'WAITS_FOR_PLAYER' ")
@NoArgsConstructor
@AllArgsConstructor
public class Game {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "first_player_id", nullable = false)
	private Player firstPlayer; 
	
	@ManyToOne
	@JoinColumn(name = "second_player_id", nullable = true)
	private Player secondPlayer;
	
	@Enumerated(EnumType.STRING)
	private Piece firstPlayerPieceCode;
	
	@Enumerated(EnumType.STRING)
	private GameType gameType;
	
	@Enumerated(EnumType.STRING)
	private GameStatus gameStatus;
	
	@Column(name = "created", nullable = false)
	private Date created;
}
