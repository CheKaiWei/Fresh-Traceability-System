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
 * ������ע����Ϣ�Ĵ������������ݴ������ݿ����ת����Ʒ��д����
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
		String []xinxi=request.getParameterValues("name");	
		//PrintWriter out =response.getWriter();	
	try{
        // ע��jdbc����
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // ���������ַ������������������˿ڣ����ݿ������û���������ȣ�
        String uri = "jdbc:mysql://localhost:3306/chatdb?user=root&password=1212&userUnicode=true&characterEncoding=GBK";
        // �������ݿ�����
        Connection connection = DriverManager.getConnection(uri);       
        // �������       
        //����ҵע����Ϣ�洢��registration����
        String sql="insert into test(test1,test2,test3,test4,test5)values(?,?,?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        for(int i=0;i<5;i++)
        	stmt.setString(i+1,xinxi[i]);  
        stmt.executeUpdate();
        stmt.close(); 
        //����ҵ����֯���������洢��CompanyRe����
        connection.close();
        //������ҵ����֯���뵽��һ��ҳ��          
       
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
