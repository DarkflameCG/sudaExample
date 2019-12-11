package com.briup.bean;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String book_numb;
	private String book_name;
	private String book_price;
	private String book_desc;
	public Book() {
		super();
	}
	public Book(String book_numb, String book_name, String book_price, String book_desc) {
		super();
		this.book_numb = book_numb;
		this.book_name = book_name;
		this.book_price = book_price;
		this.book_desc = book_desc;
	}
	public String getBook_numb() {
		return book_numb;
	}
	public void setBook_numb(String book_numb) {
		this.book_numb = book_numb;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	public String getBook_desc() {
		return book_desc;
	}
	public void setBook_desc(String book_desc) {
		this.book_desc = book_desc;
	}
	@Override
	public String toString() {
		return "Book [book_numb=" + book_numb + ", book_name=" + book_name + ", book_price=" + book_price
				+ ", book_desc=" + book_desc + "]";
	}
	
	
	
	
}
