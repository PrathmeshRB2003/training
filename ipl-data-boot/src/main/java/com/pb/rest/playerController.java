package com.pb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pb.entity.player;
import com.pb.service.playerService;

import java.util.List;

@RestController
@RequestMapping("/players")
public class playerController {

    @Autowired
    private playerService playerService;

    @PostMapping("/add/{id}")
    public void addPlayer(@RequestBody player player,@PathVariable("id") int id) {
        playerService.save(player,id);
       
    }

    @GetMapping("/{id}")
    public player getPlayer(@PathVariable int id) {
        return playerService.fetch(id);
    }

    @GetMapping("/all")
    public List<player> getAllPlayers() {
        return playerService.list();
    }
    @GetMapping("/list/{id}")
    public List<player> listByTeam(@PathVariable("id")int id){
    	return playerService.listByTeam(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.remove(id);
    }
}