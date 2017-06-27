package com.pactrex.mybatis.demo.model;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;  
  
public class Sales {  
    /** 
     *  
     */  
    private int salesId;  
      
    /** 
     *  
     */  
    private String salesName;  
      
    /** 
     *  
     */  
    private String phone;  
      
    /** 
     *  
     */  
    private String fax;  
      
    /** 
     *  
     */  
    private String email;  
      
    /** 
     *  
     */  
    private int isValid;  
  
    /** 
     *  
     */  
    private Timestamp createdTime;  
  
    /** 
     *  
     */  
    private Timestamp updateTime;  
      
    /** 
     *  
     */  
    private User userInfo;  
    
    private List<Customer> customers;  
    
    public Sales() {  
        super();  
        this.setCustomers(new ArrayList<Customer>());  
    }  
    
    @Override  
    public String toString() {  
        return "Sales [salesId=" + salesId + ", salesName=" + salesName + ", phone=" + phone + ", fax=" + fax  
                + ", email=" + email + ", isValid=" + isValid + ", createdTime=" + createdTime + ", updateTime="  
                + updateTime + ", userInfo=" + userInfo.toString() + "]";  
    } 
    
    public List<Customer> getCustomers() {  
        return customers;  
    }  
      
    protected void setCustomers(List<Customer> customers) {  
        this.customers = customers;  
    } 
  
    public int getSalesId() {  
        return salesId;  
    }  
  
    public void setSalesId(int salesId) {  
        this.salesId = salesId;  
    }  
  
    public String getSalesName() {  
        return salesName;  
    }  
  
    public void setSalesName(String salesName) {  
        this.salesName = salesName;  
    }  
  
    public String getPhone() {  
        return phone;  
    }  
  
    public void setPhone(String phone) {  
        this.phone = phone;  
    }  
  
    public String getFax() {  
        return fax;  
    }  
  
    public void setFax(String fax) {  
        this.fax = fax;  
    }  
  
    public String getEmail() {  
        return email;  
    }  
  
    public void setEmail(String eamil) {  
        this.email = eamil;  
    }  
  
    public int getIsValid() {  
        return isValid;  
    }  
  
    public void setIsValid(int isValid) {  
        this.isValid = isValid;  
    }  
  
    public Timestamp getCreatedTime() {  
        return createdTime;  
    }  
  
    public void setCreatedTime(Timestamp createdTime) {  
        this.createdTime = createdTime;  
    }  
  
    public Timestamp getUpdateTime() {  
        return updateTime;  
    }  
  
    public void setUpdateTime(Timestamp updateTime) {  
        this.updateTime = updateTime;  
    }  
  
    public User getUserInfo() {  
        return userInfo;  
    }  
  
    public void setUserInfo(User userInfo) {  
        this.userInfo = userInfo;  
    }  
}  