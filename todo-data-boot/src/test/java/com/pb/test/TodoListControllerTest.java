package com.pb.test;

import com.pb.entity.Todo;
import com.pb.entity.User;
import com.pb.repo.TodoRepository;
import com.pb.repo.UserRepository;
import com.pb.service.TodoService;
import com.pb.util.TodoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
 
import java.time.LocalDate;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.*;
 
@SpringBootTest
public class TodoListControllerTest {
 
    @Autowired
    private TodoService todoService;
 
    @Autowired
    private TodoRepository todoListRepository;
 
    @Autowired
    private UserRepository userRepository;
 
    private User user;
 
    @BeforeEach
    public void setUp() {
       
        todoListRepository.deleteAll();
        userRepository.deleteAll();
 
       
        user = new User();
        user.setUid(101);
        user.setName("John");
        
        userRepository.save(user);
    }
 
    @Test
    public void testSaveTodoList() {
        Todo todoList = new Todo();
        todoList.setTask("Test Task");
        todoList.setPriority("high");
        todoList.setFinishedDate(LocalDate.now().plusDays(1));
 
        
        todoService.save(todoList, user.getUid());
 
       
        List<Todo> todos = todoListRepository.findAll();
        assertEquals(1, todos.size());
        assertEquals("Test Task", todos.get(0).getTask());
        assertEquals(user.getUid(), todos.get(0).getUser().getUid());  // Ensure the user is linked
    }
 
    @Test
    public void testFetchTodoById() throws TodoNotFoundException {
       
        Todo todoList = new Todo();
        todoList.setTask("Fetch Task");
        todoList.setPriority("mid");
        todoList.setFinishedDate(LocalDate.now().plusDays(1));
        todoList.setUser(user);
        todoListRepository.save(todoList);
 
      
        Todo fetchedTodo = todoService.fetch(todoList.getId());
        assertNotNull(fetchedTodo);
        assertEquals(todoList.getId(), fetchedTodo.getId());
        assertEquals("Fetch Task", fetchedTodo.getTask());
    }
 
    @Test
    public void testFetchTodoListById_NotFound() {
      
        assertThrows(TodoNotFoundException.class, () -> {
            todoService.fetch(999);  // Non-existing ID
        });
    }
 
    @Test
    public void testListTodoLists() {
    
        Todo todo1 = new Todo();
        todo1.setTask("Todo 1");
        todo1.setPriority("low");
        todo1.setFinishedDate(LocalDate.now().plusDays(1));
        todo1.setUser(user);
 
        Todo todo2 = new Todo();
        todo2.setTask("Todo 2");
        todo2.setPriority("mid");
        todo2.setFinishedDate(LocalDate.now().plusDays(3));
        todo2.setUser(user);
 
        todoListRepository.save(todo1);
        todoListRepository.save(todo2);
 
       
        List<Todo> todos = todoService.list();
        assertEquals(2, todos.size());
    }
 
    @Test
    public void testRemoveTodoList() throws TodoNotFoundException {
       
        Todo todoList = new Todo();
        todoList.setTask("Todo to Remove");
        todoList.setPriority("low");
        todoList.setFinishedDate(LocalDate.now().plusDays(1));
        todoList.setUser(user);
        todoListRepository.save(todoList);
 
       
        todoService.remove(todoList.getId());
 
     
        assertFalse(todoListRepository.existsById(todoList.getId()));
    }
 
    @Test
    public void testTodoListsByUser() throws TodoNotFoundException {
       
        Todo todo1 = new Todo();
        todo1.setTask("User Todo 1");
        todo1.setPriority("low");
        todo1.setFinishedDate(LocalDate.now().plusDays(1));
        todo1.setUser(user);
 
        Todo todo2 = new Todo();
        todo2.setTask("User Todo 2");
        todo2.setPriority("mid");
        todo2.setFinishedDate(LocalDate.now().plusDays(2));
        todo2.setUser(user);
 
        todoListRepository.save(todo1);
        todoListRepository.save(todo2);
 
        List<Todo> todos = todoService.listByUser(user.getUid());
        assertEquals(2, todos.size());
    }
 
    @Test
    public void testUpdateTodoListStatus() throws TodoNotFoundException {
       
        Todo todoList = new Todo();
        todoList.setTask("Todo to Update");
        todoList.setPriority("low");
        todoList.setFinishedDate(LocalDate.now().plusDays(1));
        todoList.setUser(user);
        todoListRepository.save(todoList);
 
        todoService.updateStatus(todoList.getId());
 
        Todo updatedTodo = todoService.fetch(todoList.getId());
        assertEquals("Completed", updatedTodo.getStatus());  
    }
}