package com.kim.service;

import java.util.List;

import com.kim.model.User;

public interface UserService {
	public void register(User user);
	public User login(String username, String password);
	public List<User> showUser();
}
