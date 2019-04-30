package dsa;

//import java.io.Console;
import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * 用来对登录界面用户身份验证
 */
@WebServlet("/judge")
public class judge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public judge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//PrintWriter out =response.getWriter();
		String sql="";//连接数据库的语句，根据用户类型不同而查找不同的数据表
		String url="";//用来进行网址跳转的网址
		//获取login页面上的账号、密码以及用户类型
		String zhanghao=request.getParameter("zhanghao");
		String mima0=request.getParameter("mima0");
		String numbertype=request.getParameter("numbertype");
		//判断用户类型
		switch(numbertype)
		{
		case"0":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//委托方企业
		case"1":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//采购员
		case"2":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//仓储管理员
		case"3":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//物流员
		case"4":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//系统管理员
		case"5":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//消费用户
		}
		
		try{
			 // 注册jdbc驱动
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        // 设置连接字符串（包括主机名，端口，数据库名，用户名，密码等）
	        String uri = "jdbc:mysql://localhost:3306/chatdb?user=root&password=1212&userUnicode=true&characterEncoding=GBK";
	        // 建立数据库连接
	        Connection connection = DriverManager.getConnection(uri);       
	        // 执行查询语句，并将结果保存在product对象中
	        PreparedStatement stmt=connection.prepareStatement(sql);
	        ResultSet rs=stmt.executeQuery(sql);	
	        
	        if(rs.next())
	        {
	        	switch(numbertype)
	    		{
	        	case"0":{url="/Company/first.jsp";request.setAttribute("zhanghao", zhanghao);break;}//委托方企业
	        	case"1":;break;//采购员
	        	case"2":;break;//仓储管理员
	        	case"3":;break;//物流员
	        	case"4":;break;//系统管理员
	        	case"5":;break;//消费用户
	        	}
	        }
	        else url="/login.jsp";	        	
	        rs.close();
	        stmt.close();
	        connection.close();
	        request.getRequestDispatcher(url).forward(request,response);    
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
