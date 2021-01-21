package com.parviz.libraryms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.parviz.libraryms.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
//	@Query("from Book where title like '%:title%'")
	List<Book> findByTitleContaining(String title);
	
	Book findByIsbn(String isbn);
	
	@Transactional
	@Modifying
	@Query("update Book set status=?1, borrower_id=?2, "
			+ "borrow_date=STR_TO_DATE(?3, '%d.%m.%Y'), return_date=STR_TO_DATE(?4, '%d.%m.%Y') where isbn=?5")
	void reserveBook(String status, int borrowerId, String borrowDate, String returnDate, String isbn);

	@Transactional
	@Modifying
	@Query("update Book set status=?1 where isbn=?2")
	void giveBook(String status, String isbn);
	
	@Transactional
	@Modifying
	@Query("update Book set status=?1, borrower_id=null, "
			+ "borrow_date=null, return_date=null where isbn=?2")
	void returnBook(String status, String isbn);

	@Transactional
	@Modifying
	@Query("update Book set status=?1 where isbn=?2")
	void sendBookForRepair(String status, String isbn);

}
