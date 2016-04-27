package com.kim.eao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.kim.model.Book;

/**
 * Session Bean implementation class BookEao
 */
@Stateless
@Local
public class BookEaoBean implements BookEao {
	@PersistenceContext(unitName= "DS")
    private EntityManager em;
 
    public BookEaoBean() {
         
    }

	@Override
	public void addBook(Book book) {
		em.persist(book);
		em.flush();	
	}

	@Override
	public List<Book> getAllBook() {
		Query query = em.createQuery(
				"select t from Book t");
		List list = query.getResultList();
		if (!list.isEmpty()) {
			return list;
		}
		else {			
			return null;
		}
	}

	@Override
	public void delete(Book book) {
		 
		
	}

	@Override
	public Book getBookByName(String name) {
		Query query = em.createQuery(
				"select t from Book t where t.name =:name").setParameter(
				"name", name);
		List list = query.getResultList();
		if (!list.isEmpty()) {
			return (Book) list.get(0);
		}
		else {			
			return null;
		}
	}

	@Override
	public Book getBookById(int id) {
		Query query = em.createQuery(
				"select t from Book t where t.id =:id").setParameter(
				"id", id);
		List list = query.getResultList();
		if (!list.isEmpty()) {
			return (Book) list.get(0);
		}
		else {			
			return null;
		}
	}

}
