package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{
	private Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	private IBookRepository bookRepository;
	
	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	@Override
	public void addBook(Book book) {
		logger.info("inside add book "+book);
		bookRepository.save(book);
		logger.info("bookadded");
	}

	@Override
	public void updateBook(Book book) {
		logger.info("inside update book "+book);
		bookRepository.save(book);
		
	}
	@Override
	public void deleteBook(int bookId) {
		logger.info("inside delete book");
		bookRepository.deleteById(bookId);
		logger.error("invalid id");
	}
	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		
		Optional<Book> optbook =  bookRepository
				.findById(bookId);
		if(optbook.isEmpty()) {
			logger.error("id is invalid");
			throw new IdNotFoundException("invalid Id");
		}else
		return optbook.get();
	}
	@Override
	public List<Book> getAll() {
		logger.info("inside getall method book ");
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		logger.info("inside getByAuthor method");
		List<Book> books =  bookRepository.findByAuthor(author);
		if(books.isEmpty()) {
			logger.error("books not available"+author);
			throw new BookNotFoundException("author not found");
		}
		logger.info("got books by author"+author);
		return books;
	}

	@Override
	public List<Book> getByCategory(String category) {
		logger.info("inside getByCategory method");
		List<Book> books = bookRepository.readByCategory(category);
		if(books.isEmpty()) {
			logger.warn("books not available"+category);
			throw new BookNotFoundException("author not found");
		}
		logger.info("got books by category"+category);
		return books;
	}

	@Override
	public List<Book> getByPrice(double price) {
		return bookRepository.getByPriceLessThanEqual(price);
	}

	@Override
	public List<Book> getByPriceAuth(double cost, String author) {
		return bookRepository.findByPriceAuth(cost, author);
	}

	@Override
	public List<Book> getByCatAndAuth(String categroy, String author) {
		return bookRepository.findByCatAndAuth(categroy, author);
	}

	
	}
