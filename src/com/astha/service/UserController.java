package com.astha.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.astha.entity.User;
import com.astha.impl.UserServiceImpl;

public class UserController  extends HttpServlet{

	UserServiceImpl us = new UserServiceImpl() ;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String access = req.getParameter("access");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String username = req.getParameter("username");
		String role = req.getParameter("role");
		System.out.println(access+name+ email+ password+ mobile+username+role);
		if(access !=null && access.equals("register" )) {
			User register = new User(name, email, password, 66, username, role);
			 
			int status = us.registerUser(register);
			resp.sendRedirect("index.jsp?message="+status);
		}
		
		if(access !=null && access.equals("register" )) {
			User login = new User(email, password, username);
			 
			us.loginUser(login);
			resp.sendRedirect("homepage.jsp");
		}
		
	}
	
	
	

}
