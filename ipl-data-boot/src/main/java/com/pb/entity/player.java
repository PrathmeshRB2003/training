package com.pb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "player")
public class player {
	
	@Id
    @Column(name = "jercyNo")
	private int jercyNo;
	@Column(name = "playerName")
	private String playerName;
	@Column(name = "genre")
	private String genre;
	@Column(name = "bidAmount")
	private double bidAmount;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="teamId")
	private iplTeam team;
	public int getJercyNo() {
		return jercyNo;
	}
	public void setJercyNo(int jercyNo) {
		this.jercyNo = jercyNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public iplTeam getTeam() {
		return team;
	}
	public void setTeam(iplTeam team) {
		this.team = team;
	}
	public player(int jercyNo, String playerName, String genre, double bidAmount, iplTeam team) {
		super();
		this.jercyNo = jercyNo;
		this.playerName = playerName;
		this.genre = genre;
		this.bidAmount = bidAmount;
		this.team = team;
	}
	public player() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
