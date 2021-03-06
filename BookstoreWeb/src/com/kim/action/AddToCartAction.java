package com.kim.action;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.Book;
import com.kim.service.BookService;
import com.kim.service.CartService;
import com.opensymphony.xwork2.ActionSupport;

public class AddToCartAction extends ActionSupport {
 
	private static final long serialVersionUID = 1L;

	private String bookname;

	private int id;
	
	private int amount;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
    public String execute() throws Exception {  
    	System.out.println("enter add ");
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		BookService bookService = (BookService) context.lookup("ejb:/BookstoreEJB//BookServiceBean!com.kim.service.BookService");
    	HttpServletRequest request = ServletActionContext.getRequest();  
    	Book book = bookService.getBookById(id);  
    	CartService mcp=(CartService) request.getSession().getAttribute("cart");	
        if (mcp==null) {	     
            mcp=(CartService) context.lookup("ejb:/BookstoreEJB//CartServiceBean!com.kim.service.CartService?stateful");
        }    	
        System.out.println(book.getName());
        if (book.getQuantity() < amount)
        { 
        	System.out.println("图书不足！");
			return ERROR;
        }		        
        book.setQuantity(amount);
        /*if (!mcp.addBook(id, book))
        {
        	System.out.println("已存在！");
        	request.getSession().setAttribute("info", "购物车已经存在此书，请重新选择!");
        	return ERROR;
        }*/
        mcp.addBook(id, book);
        request.getSession().setAttribute("cart", mcp);	   
		return SUCCESS;
    }


}
