package com.pactrex.mybatis.demo.model;
import java.sql.Timestamp;  
  
public class Customer {  
  
    /** 
     *  
     */  
    private int customerId;  
  
    /** 
     *  
     */  
    private String customerName;  
  
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
  
    @Override  
    public String toString() {  
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", isValid=" + isValid  
                + ", createdTime=" + createdTime + ", updateTime=" + updateTime + ", userInfo=" + userInfo + "]";  
    }  
  
    public int getCustomerId() {  
        return customerId;  
    }  
  
    public void setCustomerId(int customerId) {  
        this.customerId = customerId;  
    }  
  
    public String getCustomerName() {  
        return customerName;  
    }  
  
    public void setCustomerName(String customerName) {  
        this.customerName = customerName;  
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