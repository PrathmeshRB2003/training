package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.entity.Todo;
import com.pb.entity.User;
import com.pb.repo.TodoRepository;
import com.pb.repo.UserRepository;
import com.pb.util.TodoNotFoundException;

@Service
public class TodoServiceImpl implements TodoService {


    @Autowired
    private TodoRepository repo;
    

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public void save(Todo todo, int id) {
        User u = userRepo.findById(id).get();
        todo.setUser(u);
        repo.save(todo);
        
    }
//
//    @Override
//    public void save(Todo todo, int uid) {
//        User user = userRepo.findById(uid).orElse(null);
//        if (user != null) {
//            todo.setUser(user);
//            repo.save(todo);
//        }
//   }

    @Override
    public Todo fetch(int id) throws TodoNotFoundException {
        return repo.findById(id).orElseThrow(()->new
        		TodoNotFoundException("no todo with id"+id));
    }

    @Override
    public List<Todo> list() {
        return repo.findAll();
    }

    @Override
    public void remove(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Todo> listByUser(int uid) {
        return repo.findByUserUid(uid);
    }

	@Override
	public List<Todo> listByStatus(String status) {
	
		return repo.findByStatus(status);
	}

	@Override
	public String updateStatus(int tid) {
		Todo t = repo.findById(tid).get();
		t.setStatus("Completed");
		repo.save(t);
		return "Updated Successfully";
	}

	

}
