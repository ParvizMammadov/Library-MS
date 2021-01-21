package com.parviz.libraryms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parviz.libraryms.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("from User where email=?1 and password=?2")
	List<User> findByEmailAndPassword(String email, String password);
	
	User findById(int id);

}
