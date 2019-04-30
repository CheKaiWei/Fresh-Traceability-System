<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "dsa.main" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
String message=(String)request.getAttribute("message");//message是8位random加上logistics——ID
String Message="http://120.78.89.20:8080/6uhfgf2/WebContent/jiemi.jsp?shuju='"+message+"'";
main Main=new main ();
String aftershu=Main.jiami(Message);
%>
<% String path=request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>
	根据您所填的表单，已为您生成相应的二维码，请自行将二维码打印下来贴在货品上，谢谢
</p>


<div id="output"></div>

<script src="<%=path%>/jquery-1.10.2.min.js"></script>

<script type="text/javascript" src="<%=path%>/jquery.qrcode.min.js"></script>

<script>
    jQuery(function(){
 //    jQuery('#qrcode').qrcode("http://www.jq22.com");
        var a="<%=aftershu%>";
	   	jQuery("#qrcode").qrcode(a);	   	
})
</script>

<div id="qrcode">二维码如下：<br></div>

</body>
</html>