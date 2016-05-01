package com.kim.action;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.User;
import com.kim.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserAction extends ActionSupport{
    public String execute() throws Exception {  
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		UserService userService = (UserService) context.lookup("ejb:/BookstoreEJB//UserServiceBean!com.kim.service.UserService");
		List<User> userlist = userService.showUser();
		HttpServletRequest request = ServletActionContext.getRequest();  
		request.getSession().setAttribute("userlist", userlist);	
		return "success";
    }
}