package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {

	
	// derived queries
	List<Book> findByAuthor(String author);
	List<Book> readByCategory(String category);
	List<Book> getByPriceLessThanEqual(double price);

	@Query("from Book b where b.author=?2 and b.price=?1")
	List<Book> findByPriceAuth(double cost, String author);

	@Query("from Book b where b.category=?1 and b.author like ?2")
	List<Book> findByCatAndAuth(String categroy, String author);



	
	
	
}
