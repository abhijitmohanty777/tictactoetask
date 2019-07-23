package com.abhi.task.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
	private Game game;
	
	@Column(name = "board_row", nullable = false)
	private int boardRow;
	
	@Column(name = "board_column", nullable = false)
	private int boardColumn;
	
	@ManyToOne
    @JoinColumn(name = "player_id", nullable = true)
	private Player player;
	
	@Column(name = "created", nullable = false)
	private  Date created;
	
	

}
