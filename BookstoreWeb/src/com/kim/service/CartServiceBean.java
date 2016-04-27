package com.kim.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateful;

import com.kim.model.Book;

/**
 * Session Bean implementation class Cart
 */
@Stateful
@Local
public class CartServiceBean implements CartService {
    public CartServiceBean() {
        
    }

	Map<Integer, Book> bMap =new HashMap<Integer, Book>();
	
	public boolean addBook(int id, Book book) {
		if (!bMap.containsKey(id) || bMap == null) {
			 bMap.put(id, book);
			 return true;
	    }
		return false;
	}
	
	public void deleteBook(int id){
	    bMap.remove(id);
	}
	
	public void deleteAllBook(){
		bMap.clear();
	}
	
	public List<Book> listCart(){
		List<Book> al = new ArrayList<Book>();
		Iterator<Integer> it = bMap.keySet().iterator();
	    while (it.hasNext()) {
	    	Book cb=bMap.get(it.next());      	 
	    	al.add(cb);
	    }
	    return al;   
	}
}
