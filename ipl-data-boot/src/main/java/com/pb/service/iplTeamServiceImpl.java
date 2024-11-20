package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.entity.iplTeam;
import com.pb.repo.iplTeamRepository;

@Service
public class iplTeamServiceImpl implements iplTeamService {
	
	@Autowired
	private iplTeamRepository repo;

	@Override
	public void save(iplTeam t) {
		// TODO Auto-generated method stub
		repo.save(t);
		
	}

	@Override
	public iplTeam fetch(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<iplTeam> list() {
		return repo.findAll();
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
		
	}
	

}
