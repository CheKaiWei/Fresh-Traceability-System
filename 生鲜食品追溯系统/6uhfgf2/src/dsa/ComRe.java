package dsa;


import java.sql.*;
public class ComRe {
	
	
	public ComReJavaBean getComRe(String zhanghao)
	{
	ComReJavaBean cjb=null;
	cjb=new ComReJavaBean();
	try{
        // ע��jdbc����
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // ���������ַ������������������˿ڣ����ݿ������û���������ȣ�
        String uri = "jdbc:mysql://localhost:3306/chatdb?user=root&password=1212&userUnicode=true&characterEncoding=GBK";
        // �������ݿ�����
        Connection connection = DriverManager.getConnection(uri);
        // �������
        String sql="select * from ComRegistration where Company_code='"+zhanghao+"'";
        PreparedStatement stmt=connection.prepareStatement(sql);
        ResultSet rs=stmt.executeQuery(sql);
        while(rs.next())
        {
        	cjb.setCompany_name(rs.getString("Company_name"));
        	cjb.setLegal_representative(rs.getString("Legal_representative"));
        	cjb.setCompany_code(rs.getString("Company_code"));
        	cjb.setCompany_address(rs.getString("Company_address"));
        	cjb.setTax_number(rs.getString("Tax_number"));
        	cjb.setCompany_nature(rs.getString("Company_nature"));
        	cjb.setRegistered_capital(rs.getString("Registered_capital"));
        	cjb.setContact_name(rs.getString("Contact_name"));
        	cjb.setContact_number(rs.getString("Contact_number"));
        	cjb.setContact_email(rs.getString("Contact_email"));
        	cjb.setpassword(rs.getString("password"));
       	}
        stmt.close();
        rs.close();
        connection.close();
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return cjb;
	}
	

}
