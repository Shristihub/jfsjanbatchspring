package com.bookapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {

	// call the methods of service layer
	private IBookService bookService;

	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}

//   http://localhost:8080/book-api/v1/books
	@PostMapping("/books")
	void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

//	http://localhost:8080/book-api/v1/books
	@PutMapping("/books")
	void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}

//	http://localhost:8080/book-api/v1/books/bookid/1
	@DeleteMapping("/books/bookid/{bookId}")
	void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
	}

//	http://localhost:8080/book-api/v1/books/bookid/1
	@GetMapping("/books/bookid/{bookId}")
	Book getById(@PathVariable("bookId") int bookId) {
		Book book = bookService.getById(bookId);
		return book;
	}

//	http://localhost:8080/book-api/v1/books
	@GetMapping("/books")
	List<Book> getAll() {
		List<Book> books = bookService.getAll();
		return books;
	}

//	http://localhost:8080/book-api/v1/books/author/Kathy
	@GetMapping("/books/author/{author}")
	List<Book> getByAuthor(@PathVariable("author")String author) {
		List<Book> books = bookService.getByAuthor(author);
		return books;
	}
//	http://localhost:8080/book-api/v1/books/price?cost=1000
	@GetMapping("/books/price")
	List<Book> getByLesserPrice(@RequestParam("cost") double price) {
		List<Book> books = bookService.getByLesserPrice(price);
		return books;
	}
//	http://localhost:8080/book-api/v1/books/author/Kathy/category/tech
	@GetMapping("/books/author/{author}/category/{category}")
	List<Book> getByAuthorCategory(@PathVariable("author")String author, 
			               @PathVariable("category")String category) {
		List<Book> books = bookService.getByAuthorCategory(author, category);
		return books;
	}
//	http://localhost:8080/book-api/v1/books/author/title?auth=kathy&title=java
	@GetMapping("/books/author/title")
	List<Book> getByAuthTitle(@RequestParam("auth")String author,
			@RequestParam("title")String title) {
		List<Book> books = bookService.getByAuthTitle(author, title);
		return books;
	}
//	http://localhost:8080/book-api/v1/books/title/java
	@GetMapping("/books/title/{title}")
	List<Book> getBooksByTitles(@PathVariable("title")String title) {
		List<Book> books = bookService.getBooksByTitles(title);
		return books;
	}
}
