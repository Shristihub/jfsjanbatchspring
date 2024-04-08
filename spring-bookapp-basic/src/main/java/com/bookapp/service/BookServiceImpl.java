package com.bookapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;
@Service // inform that this is a service layer
public class BookServiceImpl implements IBookService {
	
	private BookDetails bookDetails;
	
	@Autowired
	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = bookDetails.showBooks();
		Collections.sort(books);
		return books;
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookDetails.showBooks();
		// create a temp list
		List<Book> booksByAuthor = new ArrayList<Book>();
		// iterate the books
		for (Book book : books) {
			// check if author is available
			if (book.getAuthor().equals(author)) {
				// add to temp list
				booksByAuthor.add(book);
			}
		}
		if(booksByAuthor.isEmpty()) {
			throw new BookNotFoundException("Book by this author not found");
		}
		Collections.sort(booksByAuthor);
		return booksByAuthor;
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> books = bookDetails.showBooks();
		List<Book> booksByPrice = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getPrice()<price) {
				booksByPrice.add(book);
			}
		}
		if(booksByPrice.isEmpty()) {
			throw new BookNotFoundException("Book lesser than this price not found");
		}
		Collections.sort(booksByPrice);
		return booksByPrice;
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		List<Book> books = bookDetails.showBooks();
		boolean flag = false;
		for (Book book : books) {
			if(book.getBookId()==bookId) { 
				flag = true;
				return book;
			}
		}
		if(!flag)
			throw new IdNotFoundException("book with this id not found");
		return null;
	
	}

}
