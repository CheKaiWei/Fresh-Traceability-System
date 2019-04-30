package com.servelettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }
    String message = null;
    @Override
    public void run() 
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            while((message = br.readLine())!=null)
            {
                System.out.println("我是服务器，客户端发来的信息是："+message);
            }
            
            socket.shutdownInput();//关闭socket的输入流

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.write("欢迎访问服务器");
            socket.shutdownOutput();//关闭socket的输出流

            //关闭资源
            br.close();
            pw.close();
            socket.close();
            //注意：在使用socket进行TCP通信时，对于同一个Socket,如果关闭了输出流，
            //则与该输出流关联的socket也会被关闭，所以一般不用关闭流，直接关闭socket即可

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

    }
    
    public String Print()
    {
    	return message;
    }
}