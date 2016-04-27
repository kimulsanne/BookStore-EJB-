package com.kim.action;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.Billing;
import com.kim.model.Book;
import com.kim.model.User;
import com.kim.service.BookService;
import com.kim.service.CartService;
import com.opensymphony.xwork2.ActionSupport;

public class BuyBookAction extends ActionSupport{
		
	 public String execute() throws Exception {
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			//BillingService billingService = (BillingService) context.lookup("ejb:/BookstoreEJB//BillingServiceBean!com.kim.service.BillingService");
			/*QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			QueueConnection connection = factory.createQueueConnection();
			QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);*/
			/*Properties props = new Properties();
			props.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
			props.setProperty("java.naming.provider.url", "remote://localhost:4447");
			props.setProperty("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
			InitialContext ctx = new InitialContext(props);
			ctx.rebind("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");*/
			HttpServletRequest request = ServletActionContext.getRequest(); 	   
	    	CartService cart=(CartService) request.getSession().getAttribute("cart");
	    	
	    	//InitialContext ctx = new InitialContext();
	    	/*Hashtable<String, String> env = (Hashtable<String, String>) context .getEnvironment();
	    	System.out.println(env);*/
			QueueConnectionFactory factory
			  = (QueueConnectionFactory)context.lookup("ConnectionFactory");
			Queue dest = (Queue)context.lookup("queue/test");
			QueueConnection cnn = factory.createQueueConnection();
			QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			QueueSender sender = session.createSender(dest);
			ObjectMessage msg = session.createObjectMessage();
			
	        User user = (User) request.getSession().getAttribute("user");
	        List<Book> list = null;
			if (cart != null)
				list = cart.listCart();
			for (int i = 0; i < list.size(); i++) {
				Billing billing = new Billing();
				billing.setQuantity(list.get(i).getQuantity());
				billing.setUsername(user.getUsername());
				billing.setBookname(list.get(i).getName());	
				msg.setObject(billing);
				//billingService.addBilling(billing);
			}					
			cart.deleteAllBook();		
			request.getSession().setAttribute("info", "¹ºÂò³É¹¦!");
			request.getSession().setAttribute("cart", cart);
	    	return SUCCESS;
	 }
}
