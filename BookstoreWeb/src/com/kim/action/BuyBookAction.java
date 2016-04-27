package com.kim.action;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.Billing;
import com.kim.model.Book;
import com.kim.model.User;
import com.kim.service.BillingService;
import com.kim.service.BookService;
import com.kim.service.CartService;
import com.opensymphony.xwork2.ActionSupport;

public class BuyBookAction extends ActionSupport{
		
	 public String execute() throws Exception {
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			BillingService billingService = (BillingService) context.lookup("ejb:/BookstoreWeb//BillingServiceBean!com.kim.service.BillingService");
	    	HttpServletRequest request = ServletActionContext.getRequest(); 
	    	Hashtable<String, String> env = (Hashtable<String, String>) context .getEnvironment();
	    	System.out.println(env);	
	    	CartService cart=(CartService) request.getSession().getAttribute("cart");
	        User user = (User) request.getSession().getAttribute("user");
	        List<Book> list = null;
			if (cart != null)
				list = cart.listCart();
			for (int i = 0; i < list.size(); i++) {
				Billing billing = new Billing();
				billing.setQuantity(list.get(i).getQuantity());
				billing.setUsername(user.getUsername());
				billing.setBookname(list.get(i).getName());	
				billingService.addBilling(billing);
			}					
			cart.deleteAllBook();		
			request.getSession().setAttribute("info", "¹ºÂò³É¹¦!");
			request.getSession().setAttribute("cart", cart);
	    	return SUCCESS;
	 }
}
