package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.entity.iplTeam;
import com.pb.entity.player;
import com.pb.repo.iplTeamRepository;
import com.pb.repo.playerRepository;

@Service
public class playerServiceImpl implements playerService {
	
	@Autowired
	private playerRepository repo;
	@Autowired
	private iplTeamRepository repo2;

	@Override
	public void save(player p,int teamId) {
		// TODO Auto-generated method stub
		
		iplTeam t= repo2.findById(teamId).get();
		p.setTeam(t);
		repo.save(p);
	}

	@Override
	public player fetch(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<player> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	@Override
	public List<player> listByTeam(int id) {
		// TODO Auto-generated method stub
		return repo.listByTeam(id);
	}
	

}
