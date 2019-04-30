<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<% String zhanghao="";%>
<%
String zhanghao0=request.getParameter("zhanghao");
String zhanghao1=(String)request.getAttribute("zhanghao");
if(zhanghao0==null)zhanghao=zhanghao1;
else zhanghao=zhanghao0;
%>
<title>委托方企业主页</title>
</head>
<body>
<h1>委托方企业主页</h1>

<form name="form0" method="post" action="/6uhfgf2/Company/product.jsp"> 
<input type="hidden" name="submit0" value=<%=zhanghao%>> 
<input type="submit" name="test0" value = "go" style="display:none"> 
</form>
<form name="form1" method="post" action="/6uhfgf2/Company/Comdemand.jsp"> 
<input type="hidden" name="submit1" value=<%=zhanghao%>> 
<input type="submit" name="test1" value = "go" style="display:none"> 
</form>

<ul type="circle" style="list-style:none;line-height:50px">
<Li><a href="javascript:void(document.form0.test0.click())">产品委托 </a></Li>
<Li><a href="javascript:void(document.form1.test1.click())">企业信息查询 </a></Li>
<Li><a href="Prodemand.jsp">产品信息查询</a></Li>
</ul>
</body>
</html>