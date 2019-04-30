<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>生鲜食品追溯平台</title>
</head>
<body>
<script src="check.js"></script>
<form name='login' onsubmit='return logincheckform();' action ="servlet/judge" method="post">
<ul style="list-style:none;line-height:30px">
<Li><h2>生鲜食品追溯平台</h2></Li>
<Li>账号：<input name="zhanghao" type="text"><BR></li>
<Li>密码：<input name="mima0" type="password"><BR></li>
<Li>会员类型：<select name="numbertype">
    <option value="0">委托方企业</option>
    <option value="1">采购员</option>
    <option value="2">仓储管理员</option>
    <option value="3">物流员</option>
    <option value="4">系统管理员</option>
    <option value="5">消费用户</option>
    </select></Li>
<Li><A HREF="Company/registration.jsp" TARGET="_self">注册registration</A><BR></Li>
<Li><input type="submit" value="确定">  <input type="reset"value="清空"><BR></Li>
</ul>
</form>
</body>
</html>