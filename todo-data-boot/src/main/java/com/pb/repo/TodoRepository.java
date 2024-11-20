package com.pb.repo;
import com.pb.entity.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	@Query("FROM Todo WHERE user.uid = :uid")
	List<Todo> findByUserUid(int uid);
    
	@Query("FROM Todo t WHERE t.status = :status")
	List<Todo> findByStatus(@Param("status") String status);
	
}