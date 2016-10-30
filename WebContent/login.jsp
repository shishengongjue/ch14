<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
<div align="center">
<s:form method="post" action="Login" theme="simple">
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="300">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center">	
	<font color="#0000FF">用户登录</font>
</td>
</tr>
<tr>
	<td align="left">
		<s:fielderror/><s:property value="errormsg"/>
	</td>
</tr>
<tr>
	<td>
	请输入用户名:<s:textfield name="adminusername"/><br>
	请输入密&nbsp;码:<s:password name="adminuserpassword"/><br>
	<s:submit value="提交"/>
	<s:hidden name="action" value="login"/>
	</td>
</tr>
</table>
</s:form>
</div>
</body>
</html>