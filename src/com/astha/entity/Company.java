/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.astha.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Astha
 */
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;
    private String cName;
    private String address;
    private String createdBy;
    private int approved;

    public Company(int companyId, String cName, String address, String createdBy, int approved) {
        this.companyId = companyId;
        this.cName = cName;
        this.address = address;
        this.createdBy = createdBy;
        this.approved = approved;
    }

    public Company(String cName, String address, String createdBy, int approved) {
        this.cName = cName;
        this.address = address;
        this.createdBy = createdBy;
        this.approved = approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    public int getApproved() {
        return approved;
    }

    

    public int getCompanyId() {
        return companyId;
    }

    public String getcName() {
        return cName;
    }

    public String getAddress() {
        return address;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Company{" + "companyId=" + companyId + ", cName=" + cName + ", address=" + address + ", createdBy=" + createdBy + '}';
    }
    
    
    
}
