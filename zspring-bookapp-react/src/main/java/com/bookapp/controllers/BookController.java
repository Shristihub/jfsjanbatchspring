package com.bookapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:5173",allowedHeaders = "*")
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
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		//returns a responseentity with headers and status
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

//	http://localhost:8080/book-api/v1/books
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return ResponseEntity.accepted().build();
	}

//	http://localhost:8080/book-api/v1/books/bookid/1
	@DeleteMapping("/books/bookid/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

//	http://localhost:8080/book-api/v1/books/bookid/1
	@GetMapping("/books/bookid/{bookId}")
	ResponseEntity<Book> getById(@PathVariable("bookId") int bookId) {
		Book book = bookService.getById(bookId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting one book by id");
		return new ResponseEntity<Book>(book, headers, HttpStatus.OK);
	}

//	http://localhost:8080/book-api/v1/books
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll() {
		// this is body of response
		List<Book> books = bookService.getAll();
		System.out.println(books);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books");
		return new ResponseEntity<>(books, headers, HttpStatus.OK);
	}

//	http://localhost:8080/book-api/v1/books/author/Kathy
	@GetMapping("/books/author/{auth}")
	ResponseEntity<List<Book>> getByAuthor(@PathVariable("auth") String a) {
		List<Book> books = bookService.getByAuthor(a);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books by author ");
		headers.add("info", "Books by author");
		return ResponseEntity.ok().headers(headers).body(books);
	}

//	http://localhost:8080/book-api/v1/books/price?cost=1000
	@GetMapping("/books/price")
	ResponseEntity<List<Book>> getByLesserPrice(@RequestParam("cost")  double price) {
		List<Book> books = bookService.getByLesserPrice(price);
		return ResponseEntity.ok(books);
	}

//	http://localhost:8080/book-api/v1/books/author/Kathy/category/tech
	@GetMapping("/books/author/{author}/category/{category}")
	ResponseEntity<List<Book>> getByAuthorCategory(@PathVariable("author") String author, @PathVariable("category") String category) {
		List<Book> books = bookService.getByAuthorCategory(author, category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books by author and category"+author);
		headers.add("info", "Books by category "+category);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}

//	http://localhost:8080/book-api/v1/books/author/Kathy/category/tech
	@GetMapping("/books/category/{category}")
	ResponseEntity<List<Book>> getByCategory(@PathVariable("category") String category) {
		List<Book> books = bookService.getByCategory(category);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books by category"+category);
		headers.add("info", "Books by category "+category);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}
//	http://localhost:8080/book-api/v1/books/author/title?auth=kathy&title=java
	@GetMapping("/books/author/title")
	ResponseEntity<List<Book>> getByAuthPublisher(@RequestParam("auth") String author, @RequestParam("title") String publisher) {
		List<Book> books = bookService.getByAuthPublisher(author, publisher);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books by author and publisher"+author);
		headers.add("info", "Books by publisher "+publisher);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}

//	http://localhost:8080/book-api/v1/books/title/java
	@GetMapping("/books/title/{title}")
	ResponseEntity<List<Book>> getBooksByTitles(@PathVariable("title") String title) {
		List<Book> books = bookService.getBooksByTitles(title);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Getting all books by title");
		headers.add("info", "Books by title "+title);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(books);
	}
	
	
	
}
