package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByAuthor(String author);
	List<Book> getByPriceLessThan(double price);
	List<Book> getByAuthorAndPublisher(String author, String publisher);
	List<Book> getByCategory(String category);
	List<Book> findByLanguage(String language);
	@Query("from Book b where b.author = ?1 ")
	List<Book> findByAuth(String author);

	@Query("from Book b where b.price< ?1")
	List<Book> getBooksByLesserPrice(double nprice);
	
	@Query(value = "from Book b where b.author=?1 and b.category=?2")
	List<Book> showByAuthCat(String author, String category);
	
	// native query uses sql - here pass the book table name
	@Query(value = "select * from book where title like ?1", nativeQuery = true)
	List<Book> getByTitles(String title);
	
}
