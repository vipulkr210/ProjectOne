/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astha.service;

import com.astha.entity.Company;
import java.util.List;

/**
 *
 * @author Astha
 */
public interface CompanyService {
    public String editCompany(Company company);
    public int createCompany(Company company);
    public String deleteCompany(int id);
    public List<Company> listCompany(int userId);
    public List<Company> listCompanyBySearch(String cName, String createdBy);
    
    
}
