/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astha.connection;

/**
 *
 * @author Astha
 */
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;

public class Connection
{
  public static org.hibernate.SessionFactory sessionFactory;
  
  static {
    try {
      sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }
    catch (HibernateException e)
    {
      System.out.println(e);
    } }
  
  public Connection() {}
  
  public static org.hibernate.SessionFactory getSessionFactory() { return sessionFactory; }
}

