package com.astha.service;

import com.astha.entity.Company;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.astha.entity.Users;
import com.astha.impl.CompanyServiceImpl;
import com.astha.impl.UserServiceImpl;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

@WebServlet("/user")
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
		String roles = req.getParameter("roles");
                String companyId = req.getParameter("companyId");
        	System.out.println(access+name+ email+ password+ mobile+username+roles);
		if(access !=null && access.equals("register" )) {
                    Users register = new Users(name, email, password, 66, username, roles);
                    int status = us.registerUser(register);
                    resp.sendRedirect("index.jsp?message="+status);
		}
		
		if(access !=null && access.equals("login" )) {
                    Users login = new Users(email, password, username);
                    // List<Users> user = us.loginUser(login);
                    //if(user != null) {
                      String role="";
                      HttpSession session =req.getSession();
                       // Iterator it = user.listIterator();
                       // while(it.hasNext()){
                        //   Users u =(Users)it.next();
                        //session.setAttribute("username", u.getUsername());
                       // session.setAttribute("role", u.getRole());
                      //  session.setAttribute("name", u.getName());
                      //  session.setAttribute("userId", u.getUserId());
                      //  role=u.getRole();
                       // }
                       session.setAttribute("role", "IT_ADMIN");
                       session.setAttribute("userId", 1);
                    resp.sendRedirect("homepage.jsp?role="+role);
                  //  }
                  //  else {
                 //      resp.sendRedirect("index.jsp?role=error"); 
                    //}
               }
                if(access !=null && access.equals("approve" )) {
                    us.approveCompany(Integer.parseInt(companyId));
                    RequestDispatcher rd = req.getRequestDispatcher("homepage.jsp");
                    rd.forward(req, resp);
                }
                 if(access !=null && access.equals("listCompany" )) {
                     List<Company> list = us.listAllCompany();
                     req.setAttribute("allCompany", list);
                    RequestDispatcher rd = req.getRequestDispatcher("homepage.jsp");
                    rd.forward(req, resp);
                }
                 if(access !=null && access.equals("logout" )) {
                   HttpSession session =req.getSession();
                     session.removeAttribute("role");
                     session.removeAttribute("username");
                     session.removeAttribute("name");
                     
                     resp.sendRedirect("index.jsp");
                }
		
	}
	
	
	

}
