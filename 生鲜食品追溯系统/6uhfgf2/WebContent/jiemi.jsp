<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "dsa.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<% 
String aftershu=request.getParameter("shuju");
main Main=new main();
String Message=Main.jiemi(aftershu);
String message=Message.substring(8);
int Logistics_ID= Integer.parseInt(message);
userinfomanage userin=new userinfomanage();
UserInfo info=userin.getuser(Logistics_ID);
%>
<!-- 显示用户信息 -->
产品名称：<%=info.getProduct_name() %><BR>
 规格型号：:<%=info.getSpecification_model() %><BR>
 生产商名称：<%=info.getManufacturer_name() %><BR>
所有者名称：<%=info.getOwner_name() %><BR>
 生产日期：<%=info.getDate_of_manufacture() %><BR>
保质期：<%=info.getQuality_guarantee_period() %><BR>
生产批次：<%=info.getProduction_batch() %><BR>
</body>
</html>