package com.parviz.libraryms.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parviz.libraryms.model.Book;
import com.parviz.libraryms.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	HttpSession session;

	@RequestMapping("/books")
	public ModelAndView getAllBooks() {
		
		ModelAndView mv = new ModelAndView("books.jsp");
		List<Book> books = bookService.getAllBooks();
		mv.addObject("books", books);
		return mv;
	}
	
	@RequestMapping("/books-admin")
	public ModelAndView getAllBooksAdmin() {
		
		ModelAndView mv = new ModelAndView("books-admin.jsp");
		List<Book> books = bookService.getAllBooks();
		mv.addObject("books", books);
		return mv;
	}
	
	@GetMapping("/search-book")
	public ModelAndView getBook(@RequestParam("keyword") String title) {
		
		ModelAndView mv = new ModelAndView("book.jsp");
		List<Book> books = bookService.findByTitleContaining(title);
		mv.addObject("books", books);
		return mv;
	}
	
	@GetMapping("/search-book-admin")
	public ModelAndView getBookAdmin(@RequestParam("keyword") String title) {
		
		ModelAndView mv = new ModelAndView("book-admin.jsp");
		List<Book> books = bookService.findByTitleContaining(title);
		mv.addObject("books", books);
		return mv;
	}
	
	@PostMapping(value = "/reserve-book")
	public RedirectView reserveBook(@RequestParam("isbn") String isbn) {
		
		String status = "Reserved";
		int borrowerId = (Integer) session.getAttribute("userId");
		
		Date bDate = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String borrowDate = formatter.format(bDate);
		
		Calendar c = Calendar.getInstance();
		c.setTime(bDate);
		   
		c.add(Calendar.DATE, 15);
		   
		Date rDate = c.getTime();
		String returnDate = formatter.format(rDate);
		
		System.out.println(status+","+borrowerId+","+borrowDate+","+returnDate+","+isbn);
		
		bookService.reserveBook(status, borrowerId, borrowDate, returnDate, isbn);
		return new RedirectView("/books");
	}
	
	@PostMapping("/give-book-to-user")
	public RedirectView giveBook(@RequestParam("isbn") String isbn) {
		
		String status = "Taken";
		bookService.giveBook(status, isbn);
		return new RedirectView("/books-admin");
	}
	
	@PostMapping("/return-book")
	public RedirectView returnBook(@RequestParam("isbn") String isbn) {
		
		String status = "Ready";
		bookService.returnBook(status, isbn);
		return new RedirectView("/books-admin");
	}
	
	@PostMapping("/send-book-for-repair")
	public RedirectView sendBookForRepair(@RequestParam("isbn") String isbn) {
		
		String status = "Under repair";
		bookService.sendBookForRepair(status, isbn);
		return new RedirectView("/books-admin");
	}
}
