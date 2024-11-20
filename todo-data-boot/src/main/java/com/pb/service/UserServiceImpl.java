package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.entity.User;
import com.pb.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public void save(User user) {
		repo.save(user);
	}

	@Override
	public User fetch(int uid) {
		// TODO Auto-generated method stub
		 return repo.findById(uid).orElse(null);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void remove(int uid) {
		// TODO Auto-generated method stub
		repo.deleteById(uid);

	}

}