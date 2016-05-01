package com.kim.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kim.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

    public String excutor() {  
        try {  
        	HttpServletRequest request = ServletActionContext.getRequest(); 
        	User user = (User)request.getSession().getAttribute("user");
        	if (user != null) {     		
        		request.getSession().removeAttribute("user");
        		request.getSession().removeAttribute("cart");
        		request.getSession().removeAttribute("booklist"); 
        		request.getSession().removeAttribute("userlist");
        		return SUCCESS;
        	}
        	return SUCCESS;
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    } 
}
