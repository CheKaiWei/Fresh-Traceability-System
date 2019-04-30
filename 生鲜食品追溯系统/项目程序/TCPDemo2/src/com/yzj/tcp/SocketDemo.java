package com.yzj.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
	
	public void serversocket() {
		 ServerSocket serversocket;
		 int count = 0;
		 try {
			 for(int i = 1 ;;i++){
		         serversocket = new ServerSocket(8080);
		         System.out.println("服务器已经启动，等待客户端的连接。。。。");
		         
		         while(true)
		         {
		             Socket socket = serversocket.accept();
		             ServerThread ST = new ServerThread(socket);
		             ST.start();
		             count++;
		             System.out.println("客户端的IP:"+socket.getInetAddress().getHostAddress());
		             System.out.println("连接的客户端的总数："+count);
		             ST.Print();
		             ST.Return();
		         }
			 }
	     }catch (IOException e){
	         e.printStackTrace();
	     }
	}
}
