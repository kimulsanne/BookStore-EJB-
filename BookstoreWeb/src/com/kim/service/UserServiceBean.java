package com.kim.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kim.eao.UserEao;
import com.kim.model.User;

 
@Stateless
@Local
public class UserServiceBean implements UserService {
 
	@EJB
	private UserEao userEao;
	
    public UserServiceBean() {     
    }

	@Override
	public User login(String username, String password) {
		User user =  userEao.getUser(username);
		if (user == null) {
			return null;
		}
		else if (user.getPassword().equals(password)) {
			return user;
		}
		else {
			return null;
		}
	}

	@Override
	public void register(User user) {
		userEao.addUser(user);
	}

	@Override
	public List<User> showUser() {
		return userEao.getAllUser();
	}

}
