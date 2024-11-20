package com.pb.service;

import java.util.List;

import com.pb.entity.iplTeam;
import com.pb.entity.player;

public interface playerService {
	
    public void save(player p, int tid);
	
	public player fetch(int id);
	
	public List<player> list();
	
	public void remove(int id);
	
	public List <player> listByTeam(int id);

}
