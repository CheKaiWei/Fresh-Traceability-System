<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>产品基本信息填写</title>
    </head>
    <body>       
        <font size="6">请填写产品的基本信息：</font>
        <script src="check.js"></script>
        <form name='productlogin' onsubmit='return productcheckform();' action ="/6uhfgf2/servlet/productfromdata" method="post">
   <%String xinxi1=request.getParameter("submit0"); %> 
   <input name="number" type="hidden" value=<%=xinxi1 %>><br>
   <ul style="list-style:none;line-height:30px">
   <Li>产品名称：<input name="xinxi" type="text"><BR></Li>
   <Li> 规格型号：<input name="xinxi" type="text"><BR></Li>
   <Li>  生产商名称：<input name="xinxi" type="text"><BR></Li>
   <Li>所有者名称：<input name="xinxi" type="text"><BR></Li>
   <Li>物流包装单位：<input name="xinxi" type="text"><BR></Li>
   <Li> 包装单位所含个数：<input name="xinxi" type="text"><BR></Li>
   <Li>生产日期：<input name="xinxi" type="text"><BR></Li>
   <Li> 保质期：<input name="xinxi" type="text"><BR></Li>
   <Li>生产批次：<input name="xinxi" type="text"><BR></Li>      
   <Li> <input type="submit" value="确定">  <input type="reset"value="清空"><BR></Li>
   </ul>
        </form>           
    </body>
</html>
