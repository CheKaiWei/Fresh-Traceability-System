package dsa;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import dsa.main;

import java.sql.*;


/**
 * 用来对注册信息的处理，包括将数据存入数据库和跳转到产品填写界面
 */
@WebServlet("/processfromdata")
public class processfromdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public processfromdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//PrintWriter out =response.getWriter();
		String xinxi[]=request.getParameterValues("xinxi");
		String mima[]=request.getParameterValues("mima");		
	try{
        // 注册jdbc驱动
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // 设置连接字符串（包括主机名，端口，数据库名，用户名，密码等）
        String uri = "jdbc:mysql://120.78.89.20:3306/chatdb?user=root&password=108108Fly&userUnicode=true&characterEncoding=GBK";
        // 建立数据库连接
        Connection connection = DriverManager.getConnection(uri);       
        // 创建语句       
        //将企业注册信息存储到registration里面
        String sql="insert into ComRegistration(Company_name,Legal_representative,Company_code,Company_address,Tax_number,Company_nature,Registered_capital,Contact_name,Contact_number,Contact_email,password)values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        for(int i=0;i<10;i++)
        {
        	stmt.setString(i+1,xinxi[i]);
        }        
        stmt.setString(11,mima[0]);         
        stmt.executeUpdate();
        stmt.close(); 
        //讲企业的组织代码和密码存储到CompanyRe里面
        String sql1="insert into CompanyRe(Account_number,password)values(?,?)";
        PreparedStatement stmt1=connection.prepareStatement(sql1);
        stmt1.setString(1,xinxi[2]);
        stmt1.setString(2,mima[0]);
        stmt1.executeUpdate();
        stmt1.close(); 
        //关闭与数据库的连接
        connection.close();
        //传递企业的组织代码到下一个页面
        request.setAttribute("zhanghao", xinxi[2]);//组织机构代码
        request.getRequestDispatcher("/Company/first.jsp").forward(request,response);
       
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
