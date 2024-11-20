package com.pb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pb.entity.iplTeam;
import com.pb.service.iplTeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class iplTeamController {

    @Autowired
    private iplTeamService teamService;

    @PostMapping("/add")
    public void addTeam(@RequestBody iplTeam team) {
        teamService.save(team);
    }

    @GetMapping("/{id}")
    public iplTeam getTeam(@PathVariable int id) {
        return teamService.fetch(id);
    }

    @GetMapping("/all")
    public List<iplTeam> getAllTeams() {
        return teamService.list();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable int id) {
        teamService.remove(id);
    }
}