package com.kim.eao;

import java.util.List;

import com.kim.model.Book;

public interface BookEao {
	public void addBook(Book book);
	public Book getBookByName(String name);
	public Book getBookById(int id);
	public List<Book> getAllBook();
	public void delete(Book book);
}
