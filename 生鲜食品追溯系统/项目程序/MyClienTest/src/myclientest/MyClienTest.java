/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclientest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author aaa
 */
public class MyClienTest extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    private PrintWriter writer;
    Socket socket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();
    Container cc;
    
    public MyClienTest(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.println(tf.getText());
                ta.append(tf.getText()+"\n");
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");
            }
        });   
    }
    
    private void connect(){
        ta.append("尝试连接\n");
        try {
            for(int i = 1 ;;i++){
                socket = new Socket("120.78.89.20",8080);
            
                writer = new PrintWriter(socket.getOutputStream(),true);
                ta.append("连接成功\n");
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);
                System.err.println("请输入数据：");

                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine();
                pw.write(s);
                pw.flush();
                socket.shutdownOutput();
                pw.close();
                os.close();
                socket.close();
            }
   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        MyClienTest clien = new MyClienTest("向服务器送数据");
        clien.setSize(200,200);
        clien.setVisible(true);
        clien.connect();
    }
    
}
