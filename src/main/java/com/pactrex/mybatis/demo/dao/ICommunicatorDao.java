package com.pactrex.mybatis.demo.dao;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;  
import org.apache.ibatis.annotations.Select;

import com.pactrex.mybatis.demo.model.Communicator;  
  
public interface ICommunicatorDao {  
	
	@Insert("insert into communicator(communicator_name) values (#{communicator.communicatorName})")  
    public int insert(@Param(value = "communicator") Communicator communicator);
	
	
    @Select("SELECT * FROM communicator WHERE communicator_id=#{id}")  
    public Communicator getById(@Param(value = "id") int id);  
      
    @Select("SELECT * FROM communicator ORDER BY communicator_name")  
    public List<Communicator> getAll();  
}  