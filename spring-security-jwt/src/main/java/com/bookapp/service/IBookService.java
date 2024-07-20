package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;


public interface IBookService {

	void addBook(Book book);
	void updateBook(Book book);
	void deleteBook(int bookId);
	Book getById(int bookId) throws IdNotFoundException;
	List<Book> getAll();
	
	// derived queries
	List<Book> getByAuthor(String author ) throws BookNotFoundException;
	List<Book> getByCategory(String category)throws BookNotFoundException;
	List<Book> getByPrice(double price) throws BookNotFoundException;
	
	
	// custom query
	List<Book> getByPriceAuth(double cost,String author)throws BookNotFoundException;
	List<Book> getByCatAndAuth(String categroy, String author)throws BookNotFoundException;
	

}
