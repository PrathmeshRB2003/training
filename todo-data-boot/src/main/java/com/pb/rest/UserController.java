package com.pb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pb.entity.User;
import com.pb.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{uid}")
    public User getUser(@PathVariable int uid) {
        return userService.fetch(uid);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.list();
    }

    @DeleteMapping("/delete/{uid}")
    public void deleteUser(@PathVariable int uid) {
        userService.remove(uid);
    }
}