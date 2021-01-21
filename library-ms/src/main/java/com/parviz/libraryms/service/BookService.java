package com.parviz.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parviz.libraryms.dao.BookDao;
import com.parviz.libraryms.model.Book;

@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	public List<Book> getAllBooks() {
		return bookDao.findAll();
	}

	public List<Book> findByTitleContaining(String title) {
		return bookDao.findByTitleContaining(title);
	}
	
	public Book findByIsbn(String isbn) {
		return bookDao.findByIsbn(isbn);
	}
	
	public void reserveBook(String status, int borrowerId, String borrowDate, String returnDate, String isbn) {
		bookDao.reserveBook(status, borrowerId, borrowDate, returnDate, isbn);
	}

	public void giveBook(String status, String isbn) {
		bookDao.giveBook(status, isbn);
	}
	
	public void returnBook(String status, String isbn) {
		bookDao.returnBook(status, isbn);
	}
	
	public void sendBookForRepair(String status, String isbn) {
		bookDao.sendBookForRepair(status, isbn);
	}

}
