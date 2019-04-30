package dsa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import java.util.Random;
/**
 * �����Բ�Ʒ��Ϣ���д��������Բ�Ʒ��Ϣ�������ݿ����룬�Լ���ά�����ɽ������ת
 */
@WebServlet("/productfromdata")
public class productfromdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productfromdata() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String xinxi[]=request.getParameterValues("xinxi");	
		String number=request.getParameter("number");//��֯��������
	try{
        // ע��jdbc����
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // ���������ַ������������������˿ڣ����ݿ������û���������ȣ�
        String uri = "jdbc:mysql://120.78.89.20:3306/chatdb?user=root&password=108108Fly&userUnicode=true&characterEncoding=GBK";
        // �������ݿ�����
        Connection connection = DriverManager.getConnection(uri);       
        // ִ�в�ѯ��䣬�������������product������
        String sql="insert into product(Product_name,Specification_model,Manufacturer_name,Owner_name,Date_of_manufacture,Quality_guarantee_period,Production_batch,Company_code)values(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        for(int i=0;i<4;i++)
        {
        	stmt.setString(i+1, xinxi[i]);
        }   
        for(int i=6;i<9;i++)
        {
        	stmt.setString(i-1, xinxi[i]);
        }  
        stmt.setString(8,number);       
        boolean result=true;               
        int i=stmt.executeUpdate();
        if(i!=1)result=false;
        out.print(result); 
        stmt.close();
        
        // ִ�в�ѯ��䣬����product��ID
        String sql2="select * from product where Product_name='"+xinxi[0]+"'";
        // �������
        PreparedStatement stmt2=connection.prepareStatement(sql2);
        ResultSet rs=stmt2.executeQuery(sql2);
        int ID=0;
        while(rs.next())
        {
          ID=rs.getInt(1);
        } 
        rs.close();         
        stmt2.close();
        
        String sql1="insert into logistics(ProID,Logistics_packaging_unit,Number_of_packages)values(?,?,?)";
        PreparedStatement stmt1=connection.prepareStatement(sql1);
        for(int a=4;a<6;a++)
        {
        	stmt1.setString(a-2,xinxi[a]);
        }
        stmt1.setInt(1,ID);
        stmt1.executeUpdate();
        stmt1.close();
        //��ȡLogistics��ID
        int Logistics_ID=0;
        String sql3="select Logistics_ID from logistics where ProID="+ID;
        PreparedStatement stmt3=connection.prepareStatement(sql3);
        ResultSet rs1=stmt3.executeQuery(sql3);
        while(rs1.next())
        {
        	Logistics_ID=rs1.getInt(1);
        }
        rs1.close();         
        stmt3.close();
       
        connection.close();
        //�γ��ַ���
        Random random = new Random();
        String base = "1234567890abcdefghijklnmopqrstuvwxyzQWERTYUIOPASDFGHJKLMNBVCXZ";
        StringBuffer str = new StringBuffer();

        for(int y=0;y<8;y++)
        { int num;

        num= random.nextInt(base.length());


        str.append(base.charAt(num));
        }
        String message=str.toString();
        message+=String.valueOf(Logistics_ID);//message��8λrandom����logistics����ID
        request.setAttribute("message", message);        
        request.getRequestDispatcher("/newjsp1.jsp").forward(request,response);
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
