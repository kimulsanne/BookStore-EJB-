package com.kim.action;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kim.model.Book;
import com.kim.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class GetBookAction extends ActionSupport{
	
	private int id;
	
	private String result;
	
    public int getId() {
	
    	return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() throws Exception {  
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		BookService bookService = (BookService) context.lookup("ejb:/BookstoreEJB//BookServiceBean!com.kim.service.BookService");
		Book book = bookService.getBookById(id);
		System.out.println(book.getName());
		JSONObject json = JSONObject.fromObject(book);
		result = json.toString();
		System.out.println(result);
		return "message";
    }
}