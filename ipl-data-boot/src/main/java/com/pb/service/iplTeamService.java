package com.pb.service;

import java.util.List;

import com.pb.entity.iplTeam;

public interface iplTeamService {
	
public void save(iplTeam t);
	
	public iplTeam fetch(int id);
	
	public List<iplTeam> list();
	
	public void remove(int id);

}
