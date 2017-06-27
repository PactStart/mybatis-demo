package com.pactrex.mybatis.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.pactrex.mybatis.demo.dao.ISalesDao;
import com.pactrex.mybatis.demo.model.Sales;
import com.pactrex.mybatis.demo.service.ISalesService;

@Service
public class ISalesServiceImpl implements ISalesService ,InitializingBean{  
      
    @Resource  
    private ISalesDao dao;  
  
    @Override  
    public Sales getById(int id) {  
        return this.dao.getById(id);  
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ISalesServiceImpl created!");
		
	}  
} 