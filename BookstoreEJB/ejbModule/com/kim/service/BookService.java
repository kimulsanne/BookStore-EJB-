package com.kim.service;

import java.util.List;

import com.kim.model.Book;

public interface BookService {
	
	public List<Book> showBooks();
	public Book getBookByName(String name);
	public Book getBookById(int id);
}
