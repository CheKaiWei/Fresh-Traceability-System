<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>测试</title>
</head>
<body>
<%String []test={"a","b","c","d","e"};%>
<jsp:include page="/servlet/processfromdata">
<jsp:param name="name" value="<%=test[0] %>"/>
<jsp:param name="name" value="<%=test[1] %>"/>
<jsp:param name="name" value="<%=test[2] %>"/>
<jsp:param name="name" value="<%=test[3] %>"/>
<jsp:param name="name" value="<%=test[4] %>"/>
</jsp:include>
</body>
</html>