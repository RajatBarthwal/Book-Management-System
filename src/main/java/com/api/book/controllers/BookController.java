package com.api.book.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	// . Controller for getting all books
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBook() {

		List<Book> book = bookService.getAllBook();

		if (book.isEmpty()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.of(Optional.of(book));

	}

	// . Controller for getting book by id
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

		Book b = bookService.getBookById(id);

		if (b == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.of(Optional.of(b));
	}

	// . Controller for adding book
	@PostMapping("/books")
	public ResponseEntity<Object> addBook(@RequestBody Book b) {

		Book res = bookService.addBook(b);

		if (res != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}

		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

	}

	// . Controller for deleting book
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable("id") int id) {

		int result = bookService.deleteBookById(id);

		if (result == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		} else
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	// . Controller for updating book
	@PutMapping("/books/{id}")
	public ResponseEntity<Object> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
		Book res2 = bookService.updateBookById(id, book);

		if (res2 == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		} else
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
