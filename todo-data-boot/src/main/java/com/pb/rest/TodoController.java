package com.pb.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pb.entity.Todo;
import com.pb.service.TodoService;
import com.pb.util.TodoNotFoundException;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
    @Autowired
    private TodoService todoService;

    @PostMapping("/add/{uid}")
    public void addTodo(@Valid @RequestBody Todo todo, @PathVariable int uid) {
        todoService.save(todo, uid);
    }
    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable int id) throws TodoNotFoundException {
        return todoService.fetch(id);
    }

    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoService.list();
    }
    
    
    @GetMapping(value="/listById/{id}", produces="application/json")
	public List<Todo> getTodoListById(@PathVariable("id") int id) throws TodoNotFoundException {
	    return todoService.listByUser(id);
	}
 
	
	@GetMapping(value="/listByStatus/{status}", produces="application/json")
	public List<Todo> getListByStatus(@PathVariable("status") String status) throws TodoNotFoundException {
	    return todoService.listByStatus(status);
	}

//    @GetMapping("/list/{uid}")
//    public List<Todo> listByUser(@PathVariable int uid) {
//        return todoService.listByUser(uid);
//    }
//    
//    @GetMapping(value="/listByStatus/{status}", produces="application/json")
//	public List<Todo> getTodoListByStatus(@PathVariable("status") String status) {
//	    return todoService.findByStatus(status);
//	}

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoService.remove(id);
    }
    @PutMapping(value="/update/{tid}", produces = "application/json")
	public String updateStatus(@PathVariable("tid") int tid) {
		todoService.updateStatus(tid);
		return "Updated Successfully";
	}
    
    @ExceptionHandler(value=TodoNotFoundException.class)
	public ResponseEntity<Object> handleException(TodoNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
    
}