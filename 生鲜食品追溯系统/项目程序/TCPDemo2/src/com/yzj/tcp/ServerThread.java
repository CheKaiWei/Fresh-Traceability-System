package com.yzj.tcp;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
	
    Socket socket = null;
    String message = null;
    char[] xinxi = null;
    String[] line = null;
    //ServerThread构造器
    public ServerThread(Socket socket){
        this.socket = socket;
    }
   
    @Override
    //覆盖父类的run（）方法
    public void run(){
        try {
        	for(int i = 0;;i++) {//接收socket的数据
	            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));                        
	            while((message = br.readLine()) != null){
	                System.out.println("我是服务器，客户端发来的信息是："+message);
	            }           
	            xinxi = message.toCharArray();
	            for(int a = 0; a < 5; a++) {
	            	for(int n = 0; n < 6; n++) {
	            		line[i]+=xinxi[n];
	            	}
	            }
	            JDBCDemo jdbc = new JDBCDemo();
	            jdbc.DataBase(line);
	            
	            //关闭socket的输入流
	            socket.shutdownInput();
	            
	            //注意：在使用socket进行TCP通信时，对于同一个Socket,如果关闭了输出流，
	            //则与该输出流关联的socket也会被关闭，所以一般不用关闭流，直接关闭socket即可
        	}
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    //声明返回数据的方法
    public void Print(){
    	System.out.println("客户端发来的数据为："+message);    	
    }
    public String Return() {
    	return message;
    }
}