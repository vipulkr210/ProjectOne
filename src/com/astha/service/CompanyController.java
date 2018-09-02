/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astha.service;

import com.astha.entity.Company;
import com.astha.impl.CompanyServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Astha
 */
@WebServlet("/company")
public class CompanyController extends HttpServlet  {
    CompanyServiceImpl cimpl = new CompanyServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String access = req.getParameter("access");
        String companyId = req.getParameter("companyId");
        String cName = req.getParameter("cName");
        String address = req.getParameter("address");
        String createdBy = req.getParameter("createdBy");
        int approved = 0;
        if(access !=null && access.equals("register" )) {
            if(createdBy.equals("IT_ADMIN")){
                approved =1;
            }
            HttpSession sess= req.getSession();
	   Company company = new Company(cName, address, createdBy, approved, Integer.parseInt(sess.getAttribute("userID").toString()));
           cimpl.createCompany(company);
            resp.sendRedirect("company?access=getCompany");
           
        }
        if(access !=null && access.equals("getCompany" )) {
	    List<Company> list = cimpl.listCompany();
            req.setAttribute("list", list);
            RequestDispatcher rd = req.getRequestDispatcher("CompanyView.jsp");
            rd.forward(req, resp);
        }
        if(access !=null && access.equals("editCompany" )) {
              HttpSession sess= req.getSession();
	   Company company = new Company(cName, address, createdBy, 0 ,Integer.parseInt(sess.getAttribute("userID").toString()));
           cimpl.editCompany(Integer.parseInt(companyId), company);
            resp.sendRedirect("company?access=getCompany");
           }
        if(access !=null && access.equals("deleteCompany" )) {
            System.out.println(companyId);
            try{
	  cimpl.deleteCompany(Integer.parseInt(companyId));
            }catch(NumberFormatException ne ){ne.printStackTrace();
                
            }
          resp.sendRedirect("company?access=getCompany");
           }
        
        
        
            
            
    
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
