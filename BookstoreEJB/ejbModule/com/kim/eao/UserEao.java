package com.kim.eao;

import java.util.List;

import com.kim.model.User;
 

public interface UserEao {
	public void addUser(User user);
	public User getUser(String username);
	public List<User> getAllUser();
}
