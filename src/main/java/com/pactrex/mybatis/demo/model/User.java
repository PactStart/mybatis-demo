package com.pactrex.mybatis.demo.model;
import java.sql.Timestamp;
import java.util.Date;  
  
public class User {  
    /** 
     *  
     */  
    private int userId;  
  
    /** 
     *  
     */  
    private String userPassword;  
      
    /** 
     *  
     */  
    private String userName;  
  
    /** 
     *  
     */  
    private String nickName;  
  
    /** 
     *  
     */  
    private int userTypeId;  
  
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
    private Date createdTime;  
  
    /** 
     *  
     */  
    private Timestamp updatedTime;  
  
    public int getIsValid() {  
        return isValid;  
    }  
  
    public void setIsValid(int isValid) {  
        this.isValid = isValid;  
    }  
  
    public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {  
        return updatedTime;  
    }  
  
    public void setUpdatedTime(Timestamp updatedTime) {  
        this.updatedTime = updatedTime;  
    }  
  
    public int getUserId() {  
        return userId;  
    }  
  
    public void setUserId(int userId) {  
        this.userId = userId;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public String getNickName() {  
        return nickName;  
    }  
  
    public void setNickName(String nickName) {  
        this.nickName = nickName;  
    }  
  
    public String getEmail() {  
        return email;  
    }  
  
    public void setEmail(String eamil) {  
        this.email = eamil;  
    }  
      
    public String getUserPassword() {  
        return userPassword;  
    }  
  
    public void setUserPassword(String userPassword) {  
        this.userPassword = userPassword;  
    }  
  
    public User() {  
        this.createdTime = new Date();  
    }  
  
    public int getUserTypeId() {  
        return userTypeId;  
    }  
  
    public void setUserTypeId(int userTypeId) {  
        this.userTypeId = userTypeId;  
    }  
  
    @Override  
    public String toString() {  
        return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", eamil=" + email  
                + ", isValid=" + isValid + ", createdTime=" + createdTime + ", updatedTime=" + updatedTime + "]";  
    }  
}  