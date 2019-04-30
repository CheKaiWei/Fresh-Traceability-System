package dsa;

//import java.io.PrintWriter;
import java.sql.*;
public class userinfomanage {
	
	
	public UserInfo getuser(int shuju)
	{
		//创建userinfo类对象，并从结果集取出数据存入bean
		UserInfo user=null;	
		user =new UserInfo();	
		try{
	        // 注册jdbc驱动
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        // 设置连接字符串（包括主机名，端口，数据库名，用户名，密码等）
	        String uri = "jdbc:mysql://localhost:3306/chatdb?user=root&password=1212&userUnicode=true&characterEncoding=GBK";
	        // 建立数据库连接
	        Connection connection = DriverManager.getConnection(uri);
	        // 创建语句
	        String sql="select * from logistics where Logistics_ID="+shuju;
	        PreparedStatement stmt=connection.prepareStatement(sql);
	        ResultSet rs=stmt.executeQuery(sql);
	        int ProID=0;
	        if(rs.next())
	        {
	        	ProID=rs.getInt(1);
	        }
	        stmt.close();
	        rs.close();
	        String sql1="select * from product where ID="+ProID;
	        PreparedStatement stmt1=connection.prepareStatement(sql1);
	        ResultSet rs1=stmt1.executeQuery(sql1);
	        while(rs1.next())
	        {
	        	//创建userinfo类对象，并从结果集取出数据存入bean
	        	user.setProduct_name(rs1.getString("Product_name"));
	        	user.setSpecification_model(rs1.getString("Specification_model"));
	        	user.setManufacturer_name(rs1.getString("Manufacturer_name"));
	        	user.setOwner_name(rs1.getString("Owner_name"));	        	
	        	user.setDate_of_manufacture(rs1.getString("Date_of_manufacture"));
	        	user.setQuality_guarantee_period(rs1.getString("Quality_guarantee_period"));
	        	user.setProduction_batch(rs1.getString("Production_batch"));
	        }
	        stmt1.close();
	        rs1.close();
	        connection.close();
	       
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
		
		}
		
	}


