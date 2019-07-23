package com.abhi.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.task.DTO.PlayerDTO;
import com.abhi.task.domain.Player;
import com.abhi.task.service.PlayerService;
import com.abhi.task.service.Response;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
    PlayerService playerService;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Player createAccount(@RequestBody PlayerDTO newPlayerDTO) {
        Player newPlayer = playerService.CreateNewPlayer(newPlayerDTO);
        return newPlayer;
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public void getPlayers() {
        playerService.listplayer();}

    @RequestMapping(value = "/logged", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Player> getLoggedPlayer() {
        return new Response<>(playerService.getLoggedUser(), Response.Status.CREATED );
    }

}
