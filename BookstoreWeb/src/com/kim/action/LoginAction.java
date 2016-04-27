package com.kim.action;

 
import com.kim.jaas.SampleCallbackHandler;
import com.kim.model.User;
import com.kim.service.UserService;
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;

import java.util.Hashtable;
import java.util.Properties;

import javax.ejb.EJB;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
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
		QueueConnectionFactory factory
		  = (QueueConnectionFactory)context.lookup("ConnectionFactory");
		Queue dest = (Queue)context.lookup("queue/test");
		QueueConnection cnn = factory.createQueueConnection();
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(dest);
		ObjectMessage msg = session.createObjectMessage();
		System.out.println("end");
		UserService userService = (UserService) context.lookup("ejb:/BookstoreWeb//UserServiceBean!com.kim.service.UserService");
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