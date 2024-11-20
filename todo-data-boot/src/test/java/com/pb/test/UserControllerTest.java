package com.pb.test;
import com.pb.entity.Todo;
import com.pb.entity.User;
import com.pb.repo.TodoRepository;
import com.pb.repo.UserRepository;
import com.pb.service.TodoService;
import com.pb.service.UserService;
import com.pb.util.TodoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserControllerTest {
	
	  @Autowired
	    private UserService userService;
	  
	  @Autowired
	    private TodoRepository todoListRepository;
	 
	    @Autowired
	    private UserRepository userRepository;
	 
	    private User user;
	    
	    private List <Todo> todos = new ArrayList<Todo>();
	    
	    @BeforeEach
	    public void setUp() {
	       
	        todoListRepository.deleteAll();
	        userRepository.deleteAll();
	        
	    }
	    
	    @Test
	    public void testSaveUser() {
	    	
	    	User user= new User();
	    	user.setUid(110);
	    	user.setName("Pratham");
	    	
	        userService.save(user);
	 
	       
	        List<User> users = userRepository.findAll();
	        assertEquals(1, users.size());
	        assertEquals("Pratham", users.get(0).getName());
	        assertEquals(user.getUid(), users.get(0).getUid());  
	    }
	    
	    @Test
	    public void TestFetchUserById() {
	    	User user= new User();
	    	user.setUid(111);
	    	user.setName("Ram");
	    	
	    	userRepository.save(user);
	    	
	    	User fetUser = userService.fetch(user.getUid());
	    	assertEquals(user.getUid() ,fetUser.getUid());
	    
	    }
	    


	    
	    
	    

}
