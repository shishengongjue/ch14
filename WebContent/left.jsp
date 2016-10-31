<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<table border="1" cellpadding="0" cellspacing="0"
		style="border-collapse:collapse" bordercolor="#C0C0C0" width="140">
		<% String adminuserrole=session.getAttribute("adminuserrole") + ""; 
			int adminuserroleint=0;
			if(adminuserrole!=null&&adminuserrole.length()!=0)
				adminuserroleint=Integer.parseInt(adminuserrole);
		%>
		<%if(adminuserroleint==1||adminuserroleint==2){ %>
			<tr>
				<td width="100%" bgcolor="#C0C0C0" align="center">
				<font color="#0000FF">报到分班管理</font>
				</td>
			</tr>
				
			<tr>
				<td width="100%" align="center">
				<font><a href="class/classadmin.jsp" target="main">报到分班</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="class/classview.jsp" target="main">分班情况查询</a></font>
				</td>
			</tr>	
		<%} %>
		
		<%if(adminuserroleint==1||adminuserroleint==3){ %>
			<tr>
				<td width="100%" bgcolor="#C0C0C0" align="center">
				<font color="#0000FF">报到收费管理</font>
				</td>
			</tr>
				
			<tr>
				<td width="100%" align="center">
				<font><a href="money/acceptmoney.jsp" target="main">收费情况登记</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="class/classview.jsp" target="main">收费情况查询</a></font>
				</td>
			</tr>	
		<%} %>
		
		<%if(adminuserroleint==1||adminuserroleint==4){ %>
			<tr>
				<td width="100%" bgcolor="#C0C0C0" align="center">
				<font color="#0000FF">学生宿舍管理</font>
				</td>
			</tr>
				
			<tr>
				<td width="100%" align="center">
				<font><a href="bed/bedchamber.jsp" target="main">宿舍分配</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="class/classview.jsp" target="main">宿舍情况查询</a></font>
				</td>
			</tr>	
		<%} %>
		
		<%if(adminuserroleint==1){ %>
			<tr>
				<td width="100%" bgcolor="#C0C0C0" align="center">
				<font color="#0000FF">基础数据管理</font>
				</td>
			</tr>
				
			<tr>
				<td width="100%" align="center">
				<font><a href="basicdata/specialityadmin.jsp" target="main">录入专业</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="basicdata/matri.jsp" target="main">录入录取学生名册</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="basicdata/bedchamber.jsp" target="main">录入宿舍</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="basicdata/class.jsp" target="main">录入班级</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="basicdata/regstatus.jsp" target="main">学生报到状况查询</a></font>
				</td>
			</tr>	
			
			<tr>
				<td width="100%" align="center">
				<font><a href="basicdata/adminuser.jsp" target="main">用户管理</a></font>
				</td>
			</tr>		
		<%} %>
	</table>
	</div>
</body>
</html>