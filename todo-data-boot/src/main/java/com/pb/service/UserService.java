package com.pb.service;


import java.util.List;
import com.pb.entity.User;

public interface UserService {
    void save(User user);
    User fetch(int uid);
    List<User> list();
    void remove(int uid);
}