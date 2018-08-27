/**
 * 
 */
package com.astha.service;

import java.util.List;
import java.util.UUID;

import com.astha.entity.User;

public interface UserService {

	public void loginUser(User register);
	public int registerUser(User register);
	public void editUser(UUID userId, User user);
	public void deleteUser(UUID userId);
	public List<User> listUser();
	
}
