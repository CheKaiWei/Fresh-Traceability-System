package com.yzj.www;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
	
	public void serversocket() {
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
	     }catch (IOException e){
	         e.printStackTrace();
	     }
	}
}
