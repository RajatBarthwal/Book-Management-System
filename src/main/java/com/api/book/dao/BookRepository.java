package com.api.book.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.api.book.entities.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
		Book findById(int id);

}
