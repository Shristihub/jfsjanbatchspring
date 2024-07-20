package com.bookapp.service;

import java.util.List;
import java.util.Optional;

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
		return bookRepository.findByAuth(author);
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
//		return bookRepository.getByPriceLessThan(price);
		return bookRepository.getBooksByLesserPrice(price);

	}

	@Override
	public List<Book> getByAuthorCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = bookRepository.showByAuthCat(author, category);
		System.out.println(books);
		if (books.isEmpty())
			throw new BookNotFoundException("book by this author/category not available");
		return books;
	}

	@Override
	public List<Book> getBooksByTitles(String title) {
		return bookRepository.getByTitles("%" + title + "%");
	}

	@Override
	public List<Book> getByAuthPublisher(String author, String publisher) throws BookNotFoundException {
		List<Book> books =  bookRepository.getByAuthorAndPublisher(author, publisher);
		System.out.println(books);
		if (books.isEmpty())
			throw new BookNotFoundException("book by this author/category not available");
		return books;
	}

	@Override
	public List<Book> getByCategory(String category)  throws BookNotFoundException {
		List<Book> books =  bookRepository.getByCategory(category);
		System.out.println(books);
		if (books.isEmpty())
			throw new BookNotFoundException("book by this author/category not available");
		return books;
	}

	@Override
	public List<Book> getByLanguage(String language) throws BookNotFoundException {
		List<Book> books =  bookRepository.findByLanguage(language);
		System.out.println(books);
		if (books.isEmpty())
			throw new BookNotFoundException("book by this author/category not available");
		return books;
	}

}
