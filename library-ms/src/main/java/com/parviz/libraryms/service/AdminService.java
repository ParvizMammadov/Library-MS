package com.parviz.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parviz.libraryms.dao.AdminDao;
import com.parviz.libraryms.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;

	public List<Admin> findByEmailAndPassword(String email, String password) {
		return adminDao.findByEmailAndPassword(email, password);
	}
	
	

}
