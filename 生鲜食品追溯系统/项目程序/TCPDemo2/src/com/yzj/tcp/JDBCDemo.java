package com.yzj.tcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class JDBCDemo {
	
	
	private String xinxi[];

	public void DataBase(String[]xinxi1) {
		xinxi = xinxi1;
		try{
	        //添加驱动 
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        //连接数据库
	        String uri = "jdbc:mysql://120.78.89.20:3306/test?user=root&password=108108Fly&userUnicode=true&characterEncoding=GBK"; 
	        Connection connection = DriverManager.getConnection(uri);       
	        String sql = "insert into test(test1,test2,test3,test4,test5)values(?,?,?,?,?)";
	        PreparedStatement stmt = connection.prepareStatement(sql);        
	        //存储数据
	        for(int i=0;i<5; i++){
	        	stmt.setString(i+2, xinxi[i]);
	        }              
	        stmt.executeUpdate();
	        stmt.close(); 	
	        connection.close();		        	           
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
