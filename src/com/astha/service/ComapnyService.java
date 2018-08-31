/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astha.service;

import com.astha.entity.Company;

/**
 *
 * @author Astha
 */
public interface ComapnyService {
    public String editCompany(int id, Company company);
    public String createCompany(Company company);
    public String deleteCompany(int id);
    public String approveCompany(int id);
    
    
}
