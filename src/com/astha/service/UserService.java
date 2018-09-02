/**
 * 
 */
package com.astha.service;

import com.astha.entity.Company;
import java.util.List;
import com.astha.entity.Users;

public interface UserService {

    public List<Users> loginUser(Users register);
    public int registerUser(Users register);
    public void editUser(int userId, Users user);
    public void deleteUser(int userId);
    public List<Users> listUser();
    public String getUserType(int userId);
    public String approveCompany(int id);
    public List<Company> listAllCompany();
    
	
}
