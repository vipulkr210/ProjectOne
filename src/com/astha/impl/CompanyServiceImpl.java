/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astha.impl;

import com.astha.connection.Connection;
import com.astha.entity.Company;
import com.astha.service.CompanyService;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vipul
 */
public class CompanyServiceImpl implements CompanyService{

    @Override
    public String editCompany(Company c) {
     Session ses = Connection.getSessionFactory().openSession();
       Company company = (Company)ses.get(Company.class, c.getCompanyId());
        Transaction tr = ses.beginTransaction();
        company.setAddress(c.getAddress());
        company.setcName(c.getcName());
        ses.update(company);
        tr.commit();
        ses.close();
        return "success";
    }

    @Override
    public int createCompany(Company company) {
     Session ses = Connection.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();
                ses.save(company);
                tr.commit();
                System.out.println(company.toString());
		ses.close();
		return 1;
    }

    @Override
    public String deleteCompany(int id) {
     
        try{
            Session ses = Connection.getSessionFactory().openSession();
        
       Company company = (Company)ses.get(Company.class, id);
        Transaction tr = ses.beginTransaction();
        company.setCompanyId(id);
        ses.delete(company);
        tr.commit();
        ses.close();
        }
        catch(Exception e){e.printStackTrace();}
        return "success";
    }
    
    @Override
    public List<Company> listCompany(int userId) {
     Session ses = Connection.getSessionFactory().openSession();
        Criteria crit = ses.createCriteria(Company.class);
        crit.add(Restrictions.eq("userId", userId));
        List<Company> list =crit.list();
        return list;
     }

    @Override
    public List<Company> listCompanyBySearch(String cName, String createdBy) {
       Session ses = Connection.getSessionFactory().openSession();
        Criteria crit = ses.createCriteria(Company.class);
        if((!cName.equals("") || cName != null) && (createdBy.equals("") || createdBy == null ))
        {
            crit.add(Restrictions.like("createdBy", createdBy));
        }
        if((cName.equals("") || cName == null) && (!createdBy.equals("") && createdBy != null )){
        crit.add(Restrictions.like("createdBy", createdBy));
        }
        if((!cName.equals("") || cName != null) && (!createdBy.equals("") && createdBy != null )){
        crit.add(Restrictions.like("createdBy", createdBy));
        crit.add(Restrictions.like("createdBy", createdBy));
        }
        List<Company> list =crit.list();
        return list;
    }
    
}
