package dsa;

//import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
//import java.security.spec.*;
//import com.sun.crypto.provider.SunJCE;
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//import java.io.Serializable;
import org.apache.commons.codec.binary.Base64;
/**
 * 鎻愪緵鍔犲瘑绠楁硶锛屽彲浠ュ杈撳叆鐨勫瓧绗︿覆杩涜鍔犲瘑銆佽В瀵嗘搷浣�
*/
public class EncryptData
{
     byte[] encryptKey;
     DESedeKeySpec spec;
     SecretKeyFactory keyFactory;
     SecretKey theKey;
     Cipher cipher;
     IvParameterSpec IvParameters;

     public   EncryptData(String data)
     {
         try
         {
             // 妫�娴嬫槸鍚︽湁 TripleDES 鍔犲瘑鐨勪緵搴旂▼搴�
             // 濡傛棤锛屾槑纭湴瀹夎SunJCE 渚涘簲绋嬪簭
             try{ 
            	 //Cipher c = Cipher.getInstance("DESede"); }
             }
             catch (Exception e)
             {
                 System.err.println("Installling SunJCE provider.");
                 Provider sunjce = new com.sun.crypto.provider.SunJCE();
                 Security.addProvider(sunjce);
             }
             // 鍒涘缓涓�涓瘑閽�
             encryptKey = data.getBytes();

             // 涓轰笂涓�瀵嗛挜鍒涘缓涓�涓寚瀹氱殑 DESSede key
             spec = new DESedeKeySpec(encryptKey);

             // 寰楀埌 DESSede keys
             keyFactory = SecretKeyFactory.getInstance("DESede");

             // 鐢熸垚涓�涓� DESede 瀵嗛挜瀵硅薄
             theKey = keyFactory.generateSecret(spec);

             // 鍒涘缓涓�涓� DESede 瀵嗙爜
             cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

             // 涓� CBC 妯″紡鍒涘缓涓�涓敤浜庡垵濮嬪寲鐨� vector 瀵硅薄
             IvParameters =
                     new IvParameterSpec(new byte[]{12,34,56,78,90,87,65,43} );
         }
         catch (Exception exc)
         {
             // 璁板綍鍔犲瘑鎴栬В瀵嗘搷浣滈敊璇�
         }
     }

     /**
      * 鍔犲瘑绠楁硶
      * @param password   绛夊緟鍔犲瘑鐨勫瘑鐮�
      * @return           鍔犲瘑浠ュ悗鐨勫瘑鐮�
      * @throws Exception
      */
     public String encrypt(String password)
     {
         String encrypted_password = null;
         byte[] encrypted_pwd = null;

         try
         {
             // 浠ュ姞瀵嗘ā寮忓垵濮嬪寲瀵嗛挜
             cipher.init(Cipher.ENCRYPT_MODE,theKey,IvParameters);

             // 鍔犲瘑鍓嶇殑瀵嗙爜锛堟棫锛�
             byte[] plainttext = password.getBytes();

             // 鍔犲瘑瀵嗙爜
             encrypted_pwd = cipher.doFinal(plainttext);

             // 杞垚瀛楃涓诧紝寰楀埌鍔犲瘑鍚庣殑瀵嗙爜锛堟柊锛�
             encrypted_password = new String(encrypted_pwd);
         }
         catch(Exception ex)
         {
             // 璁板綍鍔犲瘑閿欒
         }
         encrypted_password = new String(Base64.encodeBase64(encrypted_pwd));
         return encrypted_password;
     }

     /**
      * 瑙ｅ瘑绠楁硶
      * @param password   鍔犺繃瀵嗙殑瀵嗙爜
      * @return           瑙ｅ瘑鍚庣殑瀵嗙爜
      */
     public String decrypt(String password)
     {         
         byte[] decryptedPassword = Base64.decodeBase64(password);         
         String decrypted_password = null;
         try
         {
             // 浠ヨВ瀵嗘ā寮忓垵濮嬪寲瀵嗛挜
             cipher.init(Cipher.DECRYPT_MODE,theKey,IvParameters);

             // 鏋勯�犺В瀵嗗墠鐨勫瘑鐮�
            
             // 瑙ｅ瘑瀵嗙爜
             byte[] decrypted_pwd = cipher.doFinal(decryptedPassword);
             // 寰楀埌缁撴灉
             decrypted_password = new String(decrypted_pwd);
         }
         catch(Exception ex)
         {             
             // 璁板綍瑙ｅ瘑閿欒
         }
         return decrypted_password;
     }
}