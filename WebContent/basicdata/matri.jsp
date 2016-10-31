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
<s:form method="post" action="Matri" theme="simple">
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="600">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center">	
	<font color="#0000FF">录入学生名册</font>
</td>
</tr>
<tr>
	<td width="100%" align="left">
	请输入学生姓名:
	<s:textfield name="studentname"/>
	<%-- 请选取录取专业:
	<s:select name="specialityid" listKey="SpecialityId" listValue="SpecialityName"
		list="#request.specialityArray" headerKey="" headerValue="===请选择===">
	</s:select><br> --%>
	请输入录取通知书号:<s:textfield name="matrino"/>
	<s:hidden name="action" value="add" />
	<s:submit value="提交" />
	</td>
</tr>
</table>
</s:form>
<s:form method="post" action="Matri" theme="simple">
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="600">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center" colspan="5">	
	<font color="#0000FF">查询已录入的学生名册</font>
</td>
</tr>
<tr>
	<td width="100%" align="left" colspan="5">
	请输入学生姓名:
	<s:textfield name="studentname"/>
	<%-- 请选取录取专业:
	<s:select name="specialityid" listKey="SpecialityId" listValue="SpecialityName"
		list="#request.specialityArray" headerKey="" headerValue="===请选择===">
	</s:select><br> --%>
	请输入录取通知书号:<s:textfield name="matrino"/>
	<s:hidden name="action" value="select" />
	<s:submit value="提交" />
	</td>
</tr>
<tr bgcolor="#C0C0C0">
	<td align="center"><font color="#0000FF">序号</font></td>
	<td align="center"><font color="#0000FF">姓名</font></td>
	<td align="center"><font color="#0000FF">录取专业</font></td>
	<td align="center"><font color="#0000FF">录取通知书号</font></td>
	<td align="center"><font color="#0000FF">删除?</font></td>
</tr>
<s:iterator value="#request.stuArray" status="status">
<tr>
 <td align="center"><s:property value="#status.count"/></td>
 <td align="center"><s:property value="StudentName"/></td>
 <td align="center"><s:property value="@com.csai.db.StudentUtil@havaSplitSpec(SpecialityId)"/></td>
 <td align="center"><s:property value="MatriNo"/></td>
 <td align="center">
 	<a href="Matri.action?action=del&studentid=<s:property value="StudentId"/>">删除</a>
 </td>
</tr>
</s:iterator>
<tr>
<td align="center" colspan="5">
<font color="#0000FF">
	<s:if test="#request.pagecount>1&&#request.currentpage>1">
		<a href="Matri.action?currentpage=1&action=<s:property value="action"/>
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">首页</a>
		<a href="Matri.action?currentpage=<s:property value="#request.currentpage-1" />
			&action=<s:property value="action" />
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">上一页</a>
	</s:if>
	<s:if test="#request.pagecount>1&&reuqest.currentpage<#request.pagecount">
		<a href="Matri.action?currentpage=<s:property value="#request.currentpage+1" />
			&action=<s:property value="action" />
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">下一页</a>
		<a href="Matri.action?currentpage=<s:property value="#request.pagecount" />
			&action=<s:property value="action"/>
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">尾页</a>
	</s:if>
</font>
</td>
</tr>
</table>
</s:form>
</body>
</html>