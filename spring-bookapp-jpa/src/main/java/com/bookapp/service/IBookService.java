package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {
	
	// admin 
	void addBook(Book book);  // create
	void updateBook(Book book); //update
	void deleteBook(int bookId); //delete
	Book getById(int bookId) throws IdNotFoundException; // retrieve
	
	// User
	List<Book> getAll(); // retrieve
	List<Book> getByAuthor(String author) throws BookNotFoundException;
	List<Book> getByLesserPrice(double price) throws BookNotFoundException;
	List<Book> getByAuthorCategory(String author,String category) throws BookNotFoundException;
	
	// namedquery
	List<Book> getByAuthTitle(String author, String title);
	
	// native query
	List<Book> getBooksByTitles(String title);
}
