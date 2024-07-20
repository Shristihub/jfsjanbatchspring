package com.bookapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
public class Book {
	private String title;
	private String author;
	@Id 
	@GeneratedValue 
	private Integer bookId;
	@Column(name = "cost")  // to give a different column name
	private double price;
	private String category;
	private String language;
	private String publisher;
	private String image;
	
	public Book() {
		super();
	}
	public Book(String title, String author, double price, String category, String language, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.language = language;
		this.publisher = publisher;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookId=" + bookId + ", price=" + price + ", category="
				+ category + ", language=" + language + ", publisher=" + publisher + "]";
	}
	
	
	
}
