package com.pactrex.mybatis.demo.model;
import java.sql.Timestamp;  
  
public class Communicator {  
  
    /** 
     *  
     */  
    private long communicatorId;  
  
    /** 
     *  
     */  
    private String communicatorName;  
  
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
    private int reportTo;  
  
    /** 
     *  
     */  
    private String reportToName;  
  
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
    private Timestamp updatedTime;  
  
    public long getCommunicatorId() {  
        return communicatorId;  
    }  
  
    public void setCommunicatorId(long communicatorId) {  
        this.communicatorId = communicatorId;  
    }  
  
    public String getCommunicatorName() {  
        return communicatorName;  
    }  
  
    public void setCommunicatorName(String communicatorName) {  
        this.communicatorName = communicatorName;  
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
  
    public void setEmail(String email) {  
        this.email = email;  
    }  
  
    public int getReportTo() {  
        return reportTo;  
    }  
  
    public void setReportTo(int reportTo) {  
        this.reportTo = reportTo;  
    }  
  
    public String getReportToName() {  
        return reportToName;  
    }  
  
    public void setReportToName(String reportToName) {  
        this.reportToName = reportToName;  
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
  
    public Timestamp getUpdatedTime() {  
        return updatedTime;  
    }  
  
    public void setUpdatedTime(Timestamp updatedTime) {  
        this.updatedTime = updatedTime;  
    }  
  
    @Override  
    public String toString() {  
        return "Communicator [communicatorId=" + communicatorId + ", communicatorName=" + communicatorName + ", phone="  
                + phone + ", fax=" + fax + ", email=" + email + ", reportTo=" + reportTo + ", reportToName="  
                + reportToName + ", isValid=" + isValid + ", createdTime=" + createdTime + ", updatedTime="  
                + updatedTime + "]";  
    }  
  
}  
