/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

/**
 *
 *调用函数，用来调用自己写好的加密和解密算法suanfa。Java
 */
public class main
{
    public static String jiami(String args) 
    {   
        String mima="abcdefghijklmnopqrstuvwxyz";//对称加密密钥
        String shuju=args;//原始数据       
        EncryptData EncryptData=new EncryptData(mima);
        suanfa Suanfa=new suanfa();   
              
        //加密      
        String aftershu1=Suanfa.encrypt(shuju);       
        String aftershu=EncryptData.encrypt(aftershu1);
        return aftershu;
    }
    
    public static String jiemi(String args) 
    {        
    	String mima="abcdefghijklmnopqrstuvwxyz";//对称加密密钥
    	EncryptData EncryptData=new EncryptData(mima);
        suanfa Suanfa=new suanfa(); 
        //解密
        String aftershu2=args;
        String aftershu3=EncryptData.decrypt(aftershu2);        
        String aftershu4=suanfa.decrypt(aftershu3); 
        return aftershu4;       
    }    
}
