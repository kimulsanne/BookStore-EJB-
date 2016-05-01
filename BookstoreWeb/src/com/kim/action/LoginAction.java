package com.kim.action;

 
import com.kim.jaas.SampleCallbackHandler;
import com.kim.model.Book;
import com.kim.model.User;
import com.kim.service.BookService;
import com.kim.service.UserService;
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.login.LoginContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport{  
 
    private static final long serialVersionUID = 1L;  
    private User user;  
    public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
 
    public String execute() throws Exception {  
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		
    	Hashtable<String, String> env1 = (Hashtable<String, String>) context .getEnvironment();   	
		UserService userService = (UserService) context.lookup("ejb:/BookstoreEJB//UserServiceBean!com.kim.service.UserService");
		BookService bookService = (BookService) context.lookup("ejb:/BookstoreEJB//BookServiceBean!com.kim.service.BookService");
		List<Book> booklist = bookService.showBooks();
		HttpServletRequest request = ServletActionContext.getRequest();  
		request.getSession().setAttribute("booklist", booklist);
		User user2 = userService.login(user.getUsername(), user.getPassword());
		if (user2 != null){  
			request.getSession().setAttribute("user", user2);
            return SUCCESS;  
        }else{  
            return ERROR;  
        } 
	

    }  
}