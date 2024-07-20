package com.bookapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("book-api")
@CrossOrigin("http://localhost:4200")
public class BookController {
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	private IBookService bookService;
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	@GetMapping("/greet")
	public String greet() {
	    logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return "hello";
}
	@PostMapping("/books")
	ResponseEntity<Void> addBook(@RequestBody Book book) {
		logger.info("adding one book "+book);
		bookService.addBook(book);
		logger.info("book added "+book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	@DeleteMapping("/books/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@GetMapping("/books/bookId/{bookId}")
	ResponseEntity<Book> getById(@PathVariable("bookId")int bookId) throws IdNotFoundException{
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "get book by Id");
		Book book = bookService.getById(bookId);
		
		return ResponseEntity.ok().headers(header).body(book);
	}
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll(){
		logger.info("showing all books");
		// create header and add header data key and value
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books");
		header.add("info", "API  - Get all books");
		// get the data which forms the body part
		List<Book> books = bookService.getAll();
		
		// takes body,header and status as parameter
		ResponseEntity<List<Book>> responseEntity = new ResponseEntity<>(books, header,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/books/author/{author}")
	ResponseEntity<List<Book>> getByAuthor(@PathVariable("author")String author ){
		logger.info("get books by author"+author);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books by author"+author);
		List<Book> books = bookService.getByAuthor(author);
		logger.info("got books by author"+author);
		return ResponseEntity.ok().headers(header).body(books); 
	}
	@GetMapping("/books/category")
	ResponseEntity<List<Book>> getByCategory(@RequestParam("category")String category){
		logger.info("get books by category"+category);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books by category"+category);
		List<Book> books = bookService.getByCategory(category);
		
		return ResponseEntity.ok(books);
 
	}
	@GetMapping("/books/price/{price}")
	ResponseEntity<List<Book>> getByPrice(@PathVariable("price")double price){
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Returns a list of books by price"+price);
		List<Book> books = bookService.getByPrice(price);
//		return ResponseEntity.status(HttpStatus.OK).headers(header).body(books); 
		return ResponseEntity.ok(books);
	}
	@GetMapping("/books/price/{price}/author/{author}")
	ResponseEntity<List<Book>> getByPriceAuth(@PathVariable("price")double cost,@PathVariable("author")String author){
//		return bookService.getByPriceAuth(cost, author);
		return null;
	}
	@GetMapping("/books/category/{category}/author/{author}")
	ResponseEntity<List<Book>> getByCatAndAuth(@PathVariable("category")String category, @PathVariable("author")String author){
//		return bookService.getByCatAndAuth(category, author);
		return null;
	}
	

}
