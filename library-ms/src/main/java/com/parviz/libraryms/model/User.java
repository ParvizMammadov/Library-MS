package com.parviz.libraryms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name = "username", length = 50)
	private String username;
	
	@OneToMany(mappedBy = "borrower", cascade = {CascadeType.ALL})
	private Set<Book> borrowedBooks = new HashSet<Book>();
	
	public User(int id, String email, String password, String username) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(Set<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
}
