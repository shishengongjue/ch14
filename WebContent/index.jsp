<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报到管理系统</title>
</head>
<%
	if(session.getAttribute("adminusername")==null||session.getAttribute("adminusername").toString().length()==0)
		response.sendRedirect("login.jsp");
%>
<frameset framespacing="0" border="0" frameborder="0" rows="64,*"
	marginwidth="0" marginheight="0">
	<frame name="banner" scrolling="no" noresize target="contents"
		src="banner.html">
	<frameset cols="160,*">
		<frame name="left" scrolling="auto" noresize target="main"
		src="left.jsp" marginwidth="10" marginheight="0">
		<frame name="main" scrolling="auto" marginwidth="0" marginheight="0"
			src="basicdata/regstatus.jsp">
	</frameset>
<noframes>
<body>

</body>
</noframes>
</frameset>
</html>