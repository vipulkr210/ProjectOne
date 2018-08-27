package com.astha.impl;

import java.util.List;
import java.util.UUID;

import com.astha.entity.User;
import com.astha.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public int registerUser(User register) {
		System.out.println(register.toString());
		
		return 1;
	}

	@Override
	public void editUser(UUID userId, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(UUID userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loginUser(User register) {
		System.out.println("Login success : "+register.getEmail());
		
	}
	
}
