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
 * �����Ե�¼�����û������֤
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
		String sql="";//�������ݿ����䣬�����û����Ͳ�ͬ�����Ҳ�ͬ�����ݱ�
		String url="";//����������ַ��ת����ַ
		//��ȡloginҳ���ϵ��˺š������Լ��û�����
		String zhanghao=request.getParameter("zhanghao");
		String mima0=request.getParameter("mima0");
		String numbertype=request.getParameter("numbertype");
		//�ж��û�����
		switch(numbertype)
		{
		case"0":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//ί�з���ҵ
		case"1":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//�ɹ�Ա
		case"2":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//�ִ�����Ա
		case"3":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//����Ա
		case"4":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//ϵͳ����Ա
		case"5":sql="select * from CompanyRe where Account_number='"+zhanghao+"' and password='"+mima0+"'";break;//�����û�
		}
		
		try{
			 // ע��jdbc����
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        // ���������ַ������������������˿ڣ����ݿ������û���������ȣ�
	        String uri = "jdbc:mysql://localhost:3306/chatdb?user=root&password=1212&userUnicode=true&characterEncoding=GBK";
	        // �������ݿ�����
	        Connection connection = DriverManager.getConnection(uri);       
	        // ִ�в�ѯ��䣬�������������product������
	        PreparedStatement stmt=connection.prepareStatement(sql);
	        ResultSet rs=stmt.executeQuery(sql);	
	        
	        if(rs.next())
	        {
	        	switch(numbertype)
	    		{
	        	case"0":{url="/Company/first.jsp";request.setAttribute("zhanghao", zhanghao);break;}//ί�з���ҵ
	        	case"1":;break;//�ɹ�Ա
	        	case"2":;break;//�ִ�����Ա
	        	case"3":;break;//����Ա
	        	case"4":;break;//ϵͳ����Ա
	        	case"5":;break;//�����û�
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
