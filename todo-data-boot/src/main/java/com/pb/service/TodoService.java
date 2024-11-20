package com.pb.service;

import java.util.List;
import com.pb.entity.Todo;
import com.pb.util.TodoNotFoundException;

public interface TodoService {
    void save(Todo todo, int uid);
    Todo fetch(int id) throws TodoNotFoundException;
    List<Todo> list();
    void remove(int id);
    List<Todo> listByUser(int uid);
    List<Todo> listByStatus(String status);
	public String updateStatus(int tid);
  
}
