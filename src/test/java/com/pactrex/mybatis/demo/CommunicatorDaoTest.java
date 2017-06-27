package com.pactrex.mybatis.demo;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pactrex.mybatis.demo.dao.ICommunicatorDao;
import com.pactrex.mybatis.demo.model.Communicator;  
  
public class CommunicatorDaoTest {  
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
  
    /** 
     * 下面使用了接口和注解的方式来执行同样的代码 定义一个操作数据实体表的接口，并使用注解方式把SQL查询语句与接口方法进行绑定 public 
     * interface ICommunicatorDao { @Select( 
     * "SELECT * FROM communicator WHERE communicator_id=#{id}") public 
     * Communicator getById(@Param(value = "id") int id); } 
     *  
     * 然后将接口注册到Mybatis的配置文件中即可 
     * <mappers> <mapper class="com.emerson.learning.inter.ICommunicatorDao" /> 
     * </mappers> 
     *  
     * 当数据表很多的时候，需要写很多的映射关系，这样也比较麻烦，Mybatis3.2.1提供了 一种更加简洁的方法，可以一次指定多个映射接口 
     * <mappers> <package namee="com.emerson.learning.inter" /> </mappers> 
     *  
     */  
    @Test  
    public void testGetById() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            ICommunicatorDao cp = session.getMapper(ICommunicatorDao.class);  
            Communicator c = cp.getById(1);  
            if (null == c) {  
                System.out.println("the result is null.");  
            } else {  
                System.out.println(c);  
            }  
        } finally {  
            session.close();  
        }  
    }  
  
    @Test  
    public void testGetAll() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            ICommunicatorDao cp = session.getMapper(ICommunicatorDao.class);  
            List<Communicator> list = cp.getAll();  
            for (Communicator c : list) {  
                System.out.println(c);  
            }  
        } finally {  
            session.close();  
        }  
    }
    
    @Test  
    public void insert() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            ICommunicatorDao cp = session.getMapper(ICommunicatorDao.class);  
            Communicator communicator = new Communicator();
            communicator.setCommunicatorName("leidi8");
            cp.insert(communicator);
            System.out.println("New communicator id :"+communicator.getCommunicatorId());  
        } finally {  
            session.close();  
        }  
    }  
}  