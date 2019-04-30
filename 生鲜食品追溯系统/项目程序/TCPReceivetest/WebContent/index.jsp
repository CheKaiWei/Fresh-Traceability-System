<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据测试</title>
</head>
<body>
${message}  
    <p>收到的数据为</p>  
    <% response.setIntHeader("Refresh", 1);%>
    <%=request.getAttribute("message")%>  
      
    <p>------线-----</p>  
    <%  
        String m = (String)request.getAttribute("message");  
          
    %> 
     <td>m</td>
</body>
</html>