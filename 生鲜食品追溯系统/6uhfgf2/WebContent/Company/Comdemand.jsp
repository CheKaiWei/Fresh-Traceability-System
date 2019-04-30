<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="dsa.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%String zhanghao=request.getParameter("submit1");	 %>
<title>企业基本信息</title>
</head>
<body>
<h2>企业基本信息</h2>
<%
ComRe cr=new ComRe();
ComReJavaBean cjb=cr.getComRe(zhanghao);
%>
<ul type="circle" style="list-style:none;line-height:30px">
<Li>企业名称:<%=cjb.getCompany_name() %><BR></Li>
<Li>法人代表:<%=cjb.getLegal_representative() %><BR></Li>
<Li>组织机构代码:<%=cjb.getCompany_code() %><BR></Li>
<Li>企业地址:<%=cjb.getCompany_address() %><BR></Li>
<Li>工商税务登记号:<%=cjb.getTax_number() %><BR></Li>
<Li>企业性质:<%=cjb.getCompany_nature() %><BR></Li>
<Li>注册资本:<%=cjb.getRegistered_capital() %><BR></Li>
<Li>联系人姓名:<%=cjb.getContact_name() %><BR></Li>
<Li>联系人电话:<%=cjb.getContact_number() %><BR></Li>
<Li>联系人email地址:<%=cjb.getContact_email() %><BR></Li>
</ul>
</body>
</html>