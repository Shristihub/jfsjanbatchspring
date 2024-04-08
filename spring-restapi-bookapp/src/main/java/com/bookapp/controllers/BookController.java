package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
public class BookController {

	@Autowired
	private IBookService bookService;
    //http:localhost:8080/books
	@GetMapping("/books")
	List<Book> getAll() {
		return bookService.getAll();

	}
//	http:localhost:8080/books/author/kathy
	@GetMapping("/books/author/{auth}")
	List<Book> getByAuthor(@PathVariable("auth") String author) {

		return bookService.getByAuthor(author);

	}
//	http:localhost:8080/books/price/1000
	@GetMapping("/books/price/{price}")
	List<Book> getByLesserPrice(@PathVariable("price") double price) {
		return bookService.getByLesserPrice(price);

	}
//	http:localhost:8080/books/bookId/1
	@GetMapping("/books/bookId/{bookId}")
	Book getById(@PathVariable("bookId") int bookId) {
		Book book = bookService.getById(bookId);
		if (book == null)
			throw new BookNotFoundException("invalid");
		return book;
	}
}