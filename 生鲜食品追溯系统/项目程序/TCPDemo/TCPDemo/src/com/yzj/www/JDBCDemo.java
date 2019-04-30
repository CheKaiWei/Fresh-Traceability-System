package com.yzj.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDemo {
	
	
	private String xinxi[];

	public void DataBase() {
		xinxi = null;
		try{
	        //添加驱动 
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	
	        String uri = "jdbc:mysql://120.78.89.20:3306/sensor?user=root&password=108108Fly&userUnicode=true&characterEncoding=GBK"; 
	        Connection connection = DriverManager.getConnection(uri);       
	        String sql = "insert into sensor(temperature,humidity,CO2,C2H4,O2)values(?,?,?,?,?)";
	        PreparedStatement stmt = connection.prepareStatement(sql); 
	        
	        //存储数据
	        for(int i = 0; i < 4; i++){
	        	stmt.setString(i + 1, xinxi[i]);
	        }              
	        stmt.executeUpdate();
	        stmt.close(); 	
	        connection.close();		        	           
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
