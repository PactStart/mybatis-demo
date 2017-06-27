package com.pactrex.mybatis.demo;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pactrex.mybatis.demo.model.Sales;
import com.pactrex.mybatis.demo.service.ISalesService;

public class SpringMybatisTest {  
      
    private static Logger logger = Logger.getLogger(SpringMybatisTest.class);  
      
    private ISalesService salesService = null;  
  
    @Before  
    public void setUp() throws Exception {  
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    	salesService = context.getBean(ISalesService.class);
    }  
  
    @After  
    public void tearDown() throws Exception {  
    }  
  
    @Test  
    public void test() {  
        assertNotNull(salesService);  
        Sales sales = salesService.getById(1);  
       System.out.println(sales);
    }  
  
}  