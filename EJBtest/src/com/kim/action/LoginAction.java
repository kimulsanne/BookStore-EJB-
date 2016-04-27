package com.kim.action;

 
import com.kim.jaas.SampleCallbackHandler;
import com.kim.model.User;
import com.kim.service.UserService;
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;

import java.util.Hashtable;
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
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String PROVIDER_URL = "remote://localhost:4447";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
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
		//jndiProperties.put(Context.PROVIDER_URL,"remote://localhost:4447");
		
		final Context context = new InitialContext(jndiProperties);
		//context.removeFromEnvironment(Context.INITIAL_CONTEXT_FACTORY);
		//context.addToEnvironment(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
    	Hashtable<String, String> env1 = (Hashtable<String, String>) context .getEnvironment();   	
    	System.out.println(env1);
		
		/*QueueConnectionFactory factory
		  = (QueueConnectionFactory)context.lookup("ConnectionFactory");*/
		UserService userService = (UserService) context.lookup("ejb:/BookstoreEJB//UserServiceBean!com.kim.service.UserService");
		
		User user2 = userService.login(user.getUsername(), user.getPassword());
		if (user2 != null){  
			HttpServletRequest request = ServletActionContext.getRequest();  
			request.getSession().setAttribute("user", user2);
			request.getSession().setAttribute("info", "µÇÂ¼³É¹¦!");
            return SUCCESS;  
        }else{  
            return ERROR;  
        } 
	

    }  
}