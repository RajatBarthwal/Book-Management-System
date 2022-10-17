package com.api.book.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.api.book.dao.BookRepository;

import com.api.book.entities.Author;
import com.api.book.entities.Book;

@SpringBootTest
public class TestBookRepository {
	
	@Autowired
	 BookRepository bookRepository;
	
	@Test
	void testBookById() {
		Book expectedBook =new Book(69,new Author(79, "FirstName", "LastName", 56) ,"book name");
//		bookRepository.save(expectedBook);
		
		Book actualBook= bookRepository.findById(69);
		
		assertThat(actualBook).isEqualToComparingFieldByFieldRecursively(expectedBook);
		
		
	}
	 @AfterEach
	 void deleteBook() {
		 bookRepository.deleteAll();
	 }
	
	

	
	

}
