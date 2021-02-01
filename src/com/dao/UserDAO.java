package com.dao;

import java.util.List;

import com.modals.User;

public interface UserDAO {

	public Integer addUser(User user);
	public Integer UpdateUser(User user);
	public Integer deleteUser(int id);
	public User getUserById(int id);
	public Integer getUserIdByName(String userName);
	public List<User> getAllUser();
	
}
