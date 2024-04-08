package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;


@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Override
	public void addBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		return bookRepository.findById(bookId).orElseThrow(() -> new IdNotFoundException("invalid id"));
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		return bookRepository.findByAuthor(author);
	}

}
