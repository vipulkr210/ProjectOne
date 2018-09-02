package com.astha.impl;

import com.astha.connection.Connection;
import java.util.List;
import java.util.UUID;

import com.astha.entity.User;
import com.astha.service.UserService;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserServiceImpl implements UserService {

	@Override
	public int registerUser(User register) {
		register.setUserId(UUID.randomUUID());
		Session ses = Connection.getSessionFactory().openSession();
                Transaction tr = ses.beginTransaction();
                ses.save(register);
                tr.commit();
                System.out.println(register.toString());
		
		return 1;
	}

	@Override
	public void editUser(UUID userId, User user) {
	Session ses = Connection.getSessionFactory().openSession();
        user = (User)ses.get(User.class, userId);
        Transaction tr = ses.beginTransaction();
        ses.update(user);
        tr.commit();	
	}

	@Override
	public void deleteUser(UUID userId) {
	Session ses = Connection.getSessionFactory().openSession();
        User user = (User)ses.get(User.class, userId);
        Transaction tr = ses.beginTransaction();
        ses.delete(user);
        tr.commit();	
		
	}

	@Override
	public List<User> listUser() {
	Session ses = Connection.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(User.class);
        List results = cr.list();
        return results;
	}

	@Override
	public User loginUser(User login) {
	Session ses = Connection.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(User.class);
        List results = cr.list();
        User user =null;
        Iterator it = results.listIterator();
            while(it.hasNext()){
                User user1 = (User)it.next();
                if((user1.getEmail().equals(login.getEmail())
                    || user1.getUsername().equals(login.getUsername()))
                    && user1.getPassword().equals(login.getPassword())) {
                  user = user1;
                }
            }
	return user;
	}

    @Override
    public String getUserType(UUID userId) {
        
        return "";
    }
        
        
	
}
