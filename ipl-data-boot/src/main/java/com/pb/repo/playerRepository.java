package com.pb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pb.entity.player;

public interface playerRepository extends JpaRepository<player, Integer> {
	
	
	@Query("From player where team.id =:id")
	List <player> listByTeam(@Param("id")int id);

}
