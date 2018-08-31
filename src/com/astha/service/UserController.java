package com.astha.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.astha.entity.User;
import com.astha.impl.UserServiceImpl;
import javax.servlet.http.HttpSession;

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
			 
			int status = 1;//us.registerUser(register);
			resp.sendRedirect("index.jsp?message="+status);
		}
		
		if(access !=null && access.equals("login" )) {
			User login = new User(email, password, username);
			User user = login;//us.loginUser(login);
                       /* if(user!=null) {
                            HttpSession session =req.getSession();
                            session.setAttribute("username", user.getUsername());
                            session.setAttribute("role", user.getRole());
                            session.setAttribute("name", user.getName());
                            
			resp.sendRedirect("homepage.jsp?role="+user.getRole());
                        }
                        else {
                           resp.sendRedirect("index.jsp?role=error"); 
                        }
                        */
                       resp.sendRedirect("homepage.jsp?role=IT_ADMIN&a="+user.getRole());
		}
		
	}
	
	
	

}
