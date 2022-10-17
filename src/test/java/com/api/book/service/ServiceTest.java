package com.api.book.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Author;
import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

	@MockBean
	BookRepository bookRepository;

	@Autowired
	BookService bookService;

	@BeforeAll
	void createBook() {

	}

	@Test
	public void getAllBookTest() {
		ArrayList<Book> expectedBook = new ArrayList<Book>();
		expectedBook.add(new Book(69, new Author(79, "FirstName", "LastName", 56), "book name"));
		expectedBook.add(new Book(34, new Author(77, "FirstName", "LastName", 36), "book name"));

		when(bookRepository.findAll()).thenReturn(expectedBook);
		assertEquals(2, bookService.getAllBook().size());
//		assertEquals(expectedBook, bookService.getAllBook());
	}

	@Test
	public void getBookByIdTest() {

		int id = 69;
		Book expectedBookById = new Book(69, new Author(79, "FirstName", "LastName", 56), "book name");
		when(bookRepository.findById(id)).thenReturn(expectedBookById);
		assertEquals(bookService.getBookById(69), expectedBookById);
	}

	@Test
	public void addBookTest() {
		Book expectedAddedBook = new Book(2, new Author(79, "FirstName", "LastName", 56), "book name");
		when(bookRepository.save(expectedAddedBook)).thenReturn(expectedAddedBook);

		assertEquals(expectedAddedBook, bookService.addBook(expectedAddedBook));
	}

	@Test
	public void deleteBookById() {

//		Book expectedDeletedBook = new Book(2, new Author(79, "FirstName", "LastName", 56), "book name");
		bookService.deleteBookById(2);
		verify(bookRepository).deleteById(2);
	}

	@Test
	public void updateBookById() {
		int id = 2;
		Book updatedBook = new Book(2, new Author(79, "FirstName", "LastName", 56), "book name");
		Book expectedBookById = new Book(2, new Author(69, "rajat", "Barthwal", 24), "HOD");

		when(bookRepository.findById(id)).thenReturn(expectedBookById);
		when(bookRepository.save(expectedBookById)).thenReturn(expectedBookById);

		assertEquals(updatedBook.toString(), bookService.updateBookById(2, updatedBook).toString());

	}

}
