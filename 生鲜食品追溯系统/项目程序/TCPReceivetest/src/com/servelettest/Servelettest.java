package com.servelettest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Servelettest
 */
@WebServlet("/Servelettest")
public class Servelettest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelettest() {
        super();
        // TODO Auto-generated constructor stub
        ServerSocket serversocket;
        int count = 0;
        try {
            serversocket = new ServerSocket(8080);
            System.out.println("服务器已经启动，等待客户端的连接。。。。");
            
            while(true)
            {
                Socket socket = serversocket.accept();
                new ServerThread(socket).start();
                count++;
                System.out.println("客户端的IP:"+socket.getInetAddress().getHostAddress());
                System.out.println("连接的客户端的总数："+count);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//PrintWriter out =response.getWriter();
		String xinxi[]=request.getParameterValues("message");	
	try{
        // 
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // 
        String uri = "jdbc:mysql://120.78.89.20:3306/chatdb?user=root&password=108108Fly&userUnicode=true&characterEncoding=GBK";
        // 
        Connection connection = DriverManager.getConnection(uri);       
        //
        //
        String sql="insert into ComRegistration(temperature,humidity,CO2,C2H4,O2)values(?,?,?,?,?)";
        PreparedStatement stmt=connection.prepareStatement(sql);
        for(int i=0;i<4;i++)
        {
        	stmt.setString(i+1,xinxi[i]);
        }              
        stmt.executeUpdate();
        stmt.close(); 

        connection.close();

		request.setAttribute("message", xinxi[1]);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
       
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
