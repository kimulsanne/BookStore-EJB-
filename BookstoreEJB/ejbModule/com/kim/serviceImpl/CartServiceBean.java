package com.kim.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.kim.model.Billing;
import com.kim.model.Book;
import com.kim.service.CartService;

/**
 * Session Bean implementation class Cart
 */
@Stateful
@Remote
public class CartServiceBean implements CartService{

	Map<Integer, Book> bMap =new HashMap<Integer, Book>();
	
	public CartServiceBean() {       
    }
	
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



	@Override
	public void buyBook(String userName) throws Exception {
		System.out.println("¬Ú È");
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		QueueConnectionFactory factory
		  = (QueueConnectionFactory)context.lookup("ConnectionFactory");
		Queue dest = (Queue)context.lookup("queue/test");
		QueueConnection cnn = factory.createQueueConnection();
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(dest);
		ObjectMessage msg = session.createObjectMessage();
		List<Book> list = null;
		if (bMap != null)
			list = this.listCart();
		for (int i = 0; i < list.size(); i++) {
			Billing billing = new Billing();
			billing.setQuantity(list.get(i).getQuantity());
			billing.setUsername(userName);
			billing.setBookname(list.get(i).getName());	
			System.out.println(billing.getBookname());
			msg.setObject(billing);
			//billingService.addBilling(billing);
		}	
		sender.send(msg);
		session.close();
		cnn.close();
	}
}
