package com.parviz.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parviz.libraryms.dao.UserDao;
import com.parviz.libraryms.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public void save(User user) {
		userDao.save(user);
	}
	
	public List<User> findByEmailAndPassword(String email, String password) {
		return userDao.findByEmailAndPassword(email, password);
	}
	
}
