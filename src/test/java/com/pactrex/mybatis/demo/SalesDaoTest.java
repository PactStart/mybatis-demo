package com.pactrex.mybatis.demo;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pactrex.mybatis.demo.dao.ISalesDao;
import com.pactrex.mybatis.demo.model.Sales;  
  
public class SalesDaoTest {  
  
    private Reader reader;  
    private SqlSessionFactory sqlSessionFactory;  
  
    @Before  
    public void setUp() throws Exception {  
        try {  
            reader = Resources.getResourceAsReader("mybatis-config.xml");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
    }  
  
    @After  
    public void tearDown() throws Exception {  
    }  
  
    @Test  
    public void getById() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            ISalesDao sd = session.getMapper(ISalesDao.class);  
            Sales sales = sd.getById(1);  
            assertNotNull(sales);  
//            System.out.println(sales.getSalesName());
//            System.out.println(sales.getUserInfo().getUserName());
            System.out.println(sales);
        } finally {  
            session.close();  
        }  
    }  
  
}  