package com.api.book.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id

	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	private Author author;

	private String bookName;

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", bookName=" + bookName + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, Author author, String bookName) {
		super();
		this.id = id;
		this.author = author;
		this.bookName = bookName;
	}

}
