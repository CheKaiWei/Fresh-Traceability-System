<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>企业基本信息填写</title>
        
    </head>
    <body>       
        <font size="6">请填写企业的基本信息：</font>
        <script src="check.js"></script>
        <form name='userlogin' onsubmit='return registrationcheckform();'action ="/6uhfgf2/servlet/processfromdata" method="post">
        <ul style="list-style:none;line-height:30px">
        <Li>企业名称：<input name="xinxi" type="text"><BR></Li>
        <Li>法人代表：<input name="xinxi" type="text"><BR></Li>
        <Li>组织机构代码（法定）：<input name="xinxi" type="text"><BR></Li>
        <Li>企业地址：<input name="xinxi" type="text"><BR></Li>
        <Li>工商税务登记号：<input name="xinxi" type="text"><BR></Li>
        <Li>企业性质：<input name="xinxi" type="text"><BR></Li>
        <Li>注册资本：<input name="xinxi" type="text"><BR></Li>
        <Li>联系人姓名：<input name="xinxi" type="text"><BR></Li>
        <Li>联系人电话：<input name="xinxi" type="text"><BR></Li>
        <Li>联系人email地址：<input name="xinxi" type="text"><BR></Li>
        <Li>密码：<input name="mima" type="password">12个字符以内<BR> </Li>    
        <Li>再次确认密码：<input name="mima" type="password"><BR></Li>
        <Li><input type="checkbox" name="con" value="合同"/>请详细阅读
        <A HREF="contract.jsp"TARGET="_blank">本委托销售合同</A>确认接受则可完成注册<BR></Li>    
        <Li><input type="submit" value="确定">   <input type="reset"value="清空"><BR></Li>
        </ul>
        </form>   
  
   

            
       
    </body>
</html>
