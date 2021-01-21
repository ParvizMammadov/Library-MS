package com.parviz.libraryms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.parviz.libraryms.model.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	@Query("from Admin where email=?1 and password=?2")
	List<Admin> findByEmailAndPassword(String email, String password);

}
