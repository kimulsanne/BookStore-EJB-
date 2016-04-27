package com.kim.action;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.User;
import com.kim.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

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
		UserService userService = (UserService) context.lookup("ejb:/BookstoreWeb//UserServiceBean!com.kim.service.UserService");
		userService.register(user);
 
		if(true){  
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("info", "×¢²á³É¹¦!");
            return SUCCESS;  
        }else{  
            return ERROR;  
        }  
    }


}
