package com.kim.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kim.eao.BookEao;
import com.kim.model.Book;

/**
 * Session Bean implementation class BookService
 */
@Stateless
@Local
public class BookServiceBean implements BookService {

	@EJB
	private BookEao bookEao;
	
    public BookServiceBean() {        
    }

	@Override
	public List<Book> showBooks() {	
		return bookEao.getAllBook();
	}

	@Override
	public Book getBookByName(String name) {
		return bookEao.getBookByName(name);
	}

	@Override
	public Book getBookById(int id) {
		return bookEao.getBookById(id);
	}

}
