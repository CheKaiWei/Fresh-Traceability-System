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
		//PrintWriter out =response.getWriter();
		String xinxi[]=request.getParameterValues("xinxi");
		String mima[]=request.getParameterValues("mima");		
	try{
        // ע��jdbc����
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // ���������ַ������������������˿ڣ����ݿ������û���������ȣ�
        String uri = "jdbc:mysql://120.78.89.20:3306/chatdb?user=root&password=108108Fly&userUnicode=true&characterEncoding=GBK";
        // �������ݿ�����
        Connection connection = DriverManager.getConnection(uri);       
        // �������       
        //����ҵע����Ϣ�洢��registration����
        String sql="insert into ComRegistration(Company_name,Legal_representative,Company_code,Company_address,Tax_number,Company_nature,Registered_capital,Contact_name,Contact_number,Contact_email,password)values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        for(int i=0;i<10;i++)
        {
        	stmt.setString(i+1,xinxi[i]);
        }        
        stmt.setString(11,mima[0]);         
        stmt.executeUpdate();
        stmt.close(); 
        //����ҵ����֯���������洢��CompanyRe����
        String sql1="insert into CompanyRe(Account_number,password)values(?,?)";
        PreparedStatement stmt1=connection.prepareStatement(sql1);
        stmt1.setString(1,xinxi[2]);
        stmt1.setString(2,mima[0]);
        stmt1.executeUpdate();
        stmt1.close(); 
        //�ر������ݿ������
        connection.close();
        //������ҵ����֯���뵽��һ��ҳ��
        request.setAttribute("zhanghao", xinxi[2]);//��֯��������
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
