package com.pactrex.mybatis.demo;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pactrex.mybatis.demo.model.User;  
  
  
public class UserMappingTest {  
  
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
     * 下面使用的是直接从映射配置文件中读取相应的SQL语句并执行 返回的是Object对象，需要对其进行强类型转换后才可使用 
     *  
     * 该实现方便需要为每个实体类编写一个映射文件 
     * <mapper namespace="com.pactrex.mybatis.demo.model.User">  
     *     <select id="getByID" parameterType="int" resultType="User">  
     *         SELECT user_id, user_name, nick_name, email FROM sys_user WHERE user_id = #{id} 
     *     </select> 
     * </mapper> 
     *  
     * 并注册到Mybatis配置文件中的mappers节中 
     * <mappers>  
     *     <mapper resource="com/emerson/learning/mapping/User.xml" /> 
     * </mappers> 
     *  
     */  
    @Test  
    public void testGetById() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            User user;  
            for (int i = 0; i < 2; i++) {
            	Object obj = session.selectOne("com.pactrex.mybatis.demo.model.User.getByID", 10);  
                if (null == obj) {  
                    System.out.println("the result is null.");  
                } else {  
                    user = (User) obj;  
                    System.out.println(user.getUserName());  
                    System.out.println(user.getNickName());  
                    System.out.println(user);  
                } 
			}
        } finally {  
            session.close();  
        }  
    }  
  
    /** 
     * 测试模糊查询 
     */  
    @Test  
    public void testQueryByName() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            User user = new User();  
            user.setUserName("cmzb");  
            List<User> list = session.selectList("com.pactrex.mybatis.demo.model.User.queryByName", user);  
            System.out.println(list.size());  
            for(User u: list) {  
                System.out.println(u);  
            }  
        } finally {  
            session.close();  
        }  
    }  
  
    /** 
     * 测试写入数据 
     */  
    @Test  
    public void testInsertUser() {  
        SqlSession session = sqlSessionFactory.openSession();
        try {  
            User user = new User();  
            user.setEmail("chris.mao.zb@###.com");  
            user.setNickName("Mybatis Tester");  
            user.setUserName("cmzb7");  
            user.setIsValid(1);  
            user.setUserPassword("5f4dcc3b5aa765d61d8327deb882cf99");  
  
            session.insert("com.pactrex.mybatis.demo.model.User.insertUser", user);  
            System.out.println("New Id is " + user.getUserId()); //打印出新增记录的Id值  
            session.commit(); //这里一定要使用commit，否则事务不会被提交，数据操作不会反映到数据表中  
        } finally {  
            session.close();  
        }  
    }  
    
    @Test
    public void testBatchInsertUser(){
    	SqlSession session = sqlSessionFactory.openSession();
    	List<User> userList = new ArrayList<>();
    	for (int i = 0; i < 5; i++) {
    		User user = new User();  
            user.setEmail("chris.mao.zb@###.com");  
            user.setNickName("Mybatis Tester");  
            user.setUserName("cmzb_"+i);  
            user.setIsValid(1);  
            user.setUserPassword("5f4dcc3b5aa765d61d8327deb882cf99");  
            
            userList.add(user);
		}
        try {  
            session.insert("com.pactrex.mybatis.demo.model.User.insertBatch", userList);  
            session.commit(); //这里一定要使用commit，否则事务不会被提交，数据操作不会反映到数据表中  
        } finally {  
            session.close();  
        }  
    }
  
    /** 
     * 测试更新数据 
     */  
    @Test  
    public void testUpdateUser() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            User user = session.selectOne("com.pactrex.mybatis.demo.model.User.getByID", 1);  
            user.setEmail("chris.mao.zb@＃＃＃.com");  
            user.setNickName("ChrisMao");  
            user.setIsValid(0);  
  
            session.update("com.pactrex.mybatis.demo.model.User.updateUser", user);  
            session.commit();//这里一个要commit，否则更新是不会写入到数据表中的  
        } finally {  
            session.close();  
        }  
    }  
  
    /** 
     * 测试单条删除 
     */  
    @Test  
    public void testDeleteById() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            session.delete("com.pactrex.mybatis.demo.model.User.deleteById", 3);  
            session.commit();  
        } finally {  
            session.close();  
        }  
    }  
      
    /** 
     * 测试批量删除 
     */  
    @Test  
    public void testDeleteBatch() {  
        SqlSession session = sqlSessionFactory.openSession();  
        try {  
            List<Integer> idList = new ArrayList<Integer>();  
            idList.add(1);  
            idList.add(2);  
            session.delete("com.pactrex.mybatis.demo.model.User.deleteBatch", idList);  
            session.commit();  
        } finally {  
            session.close();  
        }  
    }  
}  