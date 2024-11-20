package com.pb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teams")
public class iplTeam {
	
	@Id
	private int teamId;
	
	@Column(name="TeamName")
	private String teamName;

	private String state;
	@Column(name="players")
	
	@JsonManagedReference
	@OneToMany(mappedBy =  "team",cascade=CascadeType.REMOVE)
	private List <player> players;
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<player> getPlayers() {
		return players;
	}
	public void setPlayers(List<player> players) {
		this.players = players;
	}
	public iplTeam(int teamId, String teamName, String state, List<player> players) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.state = state;
		this.players = players;
	}
	public iplTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
