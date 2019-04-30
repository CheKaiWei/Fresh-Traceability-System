/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

//import java.util.Random;
//import java.io.UnsupportedEncodingException;
/**
 *
 * 自己编写的加密算法和解密算法的类，用来给main。Java来调用的
 */
public class suanfa
{   
     public static String encrypt(String shuju)//用来调用换位huanwei和移位jiayiwei算法
     {
    	 char[] data1=shuju.toCharArray();      
    	 for(int i=0;i<data1.length;i++)
    	 {             
    		 data1=huanwei(data1);
    		 data1=jiayiwei(data1);
    	 }                 
    	 String y=new String(data1);
    	 return y;
   	 }
     
     
      private static char[]huanwei(char[] data1)//三个为一组，组内第二个和第三个调换顺序，简称换位
      {
    	  int a=data1.length;
    	  for(int i=0;i<a/3;i++)
    	  {
    		  char temp;    
    		  temp=data1[3*i+1];
    		  data1[3*i+1]=data1[3*i+2];
    		  data1[3*i+2]=temp;  
    	  } 
    	  return data1;
   	  }
     
      
      private static char[]jiayiwei(char[] data)//整体向左移位
      {
    	  char []data1=data;
    	  int i=data1.length;
    	  char s=data1[0];
    	  for(int j=0;j<i-1;j++)
    	  {
    		  data1[j]=data1[j+1];
    	  }
    	  data1[i-1]=s; 
    	  return data1;
   	  }
      

     public static String decrypt(String data)//用来调用换位huanwei和移位jianyiwei算法
     {
    	 char[] data1=data.toCharArray();
    	 for(int i=0;i<data1.length;i++)
    	 { 
    		 data1=jianyiwei(data1); 
    		 data1=huanwei(data1); 
   		 }    
    	 String shuju=String.valueOf(data1);
    	 return shuju; 
   	 }
     
     
     private static char[]jianyiwei(char[] data)//整体向右移位
     {
    	 int i=data.length;
    	 char []data1=data; 
    	 char s=data1[i-1];
    	 for(int a=i-1;a>0;a--)
    	 {
    		 data1[a]=data[a-1];
    	 }
    	 data1[0]=s; 
    	 return data1;
   	 }
}
