package com.kim.action;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.Book;
import com.kim.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBookAction extends ActionSupport{
    public String execute() throws Exception {  
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		BookService bookService = (BookService) context.lookup("ejb:/BookstoreEJB//BookServiceBean!com.kim.service.BookService");
		List<Book> booklist = bookService.showBooks();
		HttpServletRequest request = ServletActionContext.getRequest();  
		request.getSession().setAttribute("booklist", booklist);	
		return "success";
    }
}