package com.astha.impl;

import com.astha.connection.Connection;
import com.astha.entity.Company;
import java.util.List;
import java.util.UUID;

import com.astha.entity.Users;
import com.astha.service.UserService;
import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserServiceImpl implements UserService {

	@Override
	public int registerUser(Users register) {
		Session ses = Connection.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();
                ses.save(register);
                tr.commit();
                System.out.println(register.toString());
		ses.close();
		return 1;
	}

	@Override
	public void editUser(int userId, Users user) {
	Session ses = Connection.getSessionFactory().openSession();
        user = (Users)ses.get(Users.class, userId);
        Transaction tr = ses.beginTransaction();
        ses.update(user);
        tr.commit();	
        ses.close();
	}

	@Override
	public void deleteUser(int userId) {
	Session ses = Connection.getSessionFactory().openSession();
        Users user = (Users)ses.get(Users.class, userId);
        Transaction tr = ses.beginTransaction();
        ses.delete(user);
        ses.close();
        tr.commit();	
		
	}

	@Override
	public List<Users> listUser() {
	Session ses = Connection.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(Users.class);
        ses.close();
        List results = cr.list();
        ses.close();
        return results;
	}

	@Override
	public List<Users> loginUser(Users login) {
        Session ses = Connection.getSessionFactory().openSession();
        Query q = ses.createQuery("from Users where (email='"+login.getEmail()+"' or username='"+login.getUsername()+"') and password='"+login.getPassword()+"'" );
        Users user = new Users();      
        List<Users> list=(List<Users>)q.list();
        ses.close();
	return list;
	}

    @Override
    public String getUserType(int userId) {
        
        return "";
    }
      
    @Override
    public String approveCompany(int id) {
    Session ses = Connection.getSessionFactory().openSession();
       Company company = (Company)ses.get(Company.class, id);
        Transaction tr = ses.beginTransaction();
        company.setApproved(1);
        ses.update(company);
        tr.commit();
        ses.close();
        return "success";
    }

    @Override
    public List<Company> listAllCompany() {
    Session ses = Connection.getSessionFactory().openSession();
        Criteria crit = ses.createCriteria(Company.class);
        //crit.add(Restrictions.eqProperty("", otherPropertyName))
        List<Company> list =crit.list();
        ses.close();
        return list;
     }

        
	
}
