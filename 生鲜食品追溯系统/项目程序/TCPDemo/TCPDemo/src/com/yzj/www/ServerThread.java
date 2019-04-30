package com.yzj.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket = null;
    
    //ServerThread构造器
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    
    String message = null;
    @Override
    //覆盖父类的run（）方法
    public void run(){
        try {
        	//接收socket的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));            
            while((message = br.readLine())!=null){
                System.out.println("我是服务器，客户端发来的信息是："+message);
            }
            //关闭socket的输入流
            socket.shutdownInput();
            
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("欢迎访问服务器");
            //关闭socket的输出流
            socket.shutdownOutput();

            //关闭资源
            br.close();
            pw.close();
            socket.close();
            //注意：在使用socket进行TCP通信时，对于同一个Socket,如果关闭了输出流，
            //则与该输出流关联的socket也会被关闭，所以一般不用关闭流，直接关闭socket即可
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    //声明返回数据的方法
    public String Print(){
    	return message;
    }
}