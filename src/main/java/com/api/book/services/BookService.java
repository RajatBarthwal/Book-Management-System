package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	// 1. Get all book
	public List<Book> getAllBook() {
		return (List<Book>) bookRepository.findAll();

	}

	// 2. Get book by id

	public Book getBookById(int id) {
		Book b = null;
		try {

			b = bookRepository.findById(id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return b;

	}

// 3. add book
	public Book addBook(Book b) {
		Book book = bookRepository.save(b);
		return book;

	}

	// . Delete book by id
	public int deleteBookById(int id) {
		int temp = 0;

		try {
			bookRepository.deleteById(id);
			temp++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;

	}

//. Update book by id
	public Book updateBookById(int id, Book book) {

		Book updatedBook = bookRepository.findById(id);
		updatedBook.setAuthor(book.getAuthor());
		updatedBook.setBookName(book.getBookName());
		Book newBook = bookRepository.save(updatedBook);

		return newBook;
	}

}
