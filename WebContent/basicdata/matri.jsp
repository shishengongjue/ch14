<%@page import="com.csai.db.StudentUtil"%>
<%@page import="com.csai.POJO.Speciality"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<s:form method="post" action="Matri" theme="simple">
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="600">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center">	
	<font color="#0000FF">¼��ѧ������</font>
</td>
</tr>
<tr>
	<td width="100%" align="left">
	������ѧ������:
	<s:textfield name="studentname"/><br>
	��ѡȡ¼ȡרҵ:
	<select name="specialityid">
		<option value="">===��ѡ��===</option>
		<%
		ArrayList<Speciality> spe =StudentUtil.specialities();
		for(int i=0;i<spe.size();i++) {%>
		<option value="<%=spe.get(i).SpecialityId%>"><%=spe.get(i).SpecialityName %></option>
		<%} %>
	</select><br>
	������¼ȡ֪ͨ���:<s:textfield name="matrino"/>
	<s:hidden name="action" value="add" />
	<s:submit value="�ύ" />
	</td>
</tr>
</table>
</s:form>
<s:form method="post" action="Matri" theme="simple">
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="600">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center" colspan="5">	
	<font color="#0000FF">��ѯ��¼���ѧ������</font>
</td>
</tr>
<tr>
	<td width="100%" align="left" colspan="5">
	������ѧ������:
	<s:textfield name="studentname"/><br>
	��ѡȡ¼ȡרҵ:
	<select name="specialityid">
		<option value="">===��ѡ��===</option>
		<%
		ArrayList<Speciality> spe =StudentUtil.specialities();
		for(int i=0;i<spe.size();i++) {%>
		<option value="<%=spe.get(i).SpecialityId%>"><%=spe.get(i).SpecialityName %></option>
		<%} %>
	</select><br>
	������¼ȡ֪ͨ���:<s:textfield name="matrino"/>
	<s:hidden name="action" value="select" />
	<s:submit value="�ύ" />
	</td>
</tr>
<tr bgcolor="#C0C0C0">
	<td align="center"><font color="#0000FF">���</font></td>
	<td align="center"><font color="#0000FF">����</font></td>
	<td align="center"><font color="#0000FF">¼ȡרҵ</font></td>
	<td align="center"><font color="#0000FF">¼ȡ֪ͨ���</font></td>
	<td align="center"><font color="#0000FF">ɾ��?</font></td>
</tr>
<s:iterator value="#request.stuArray" status="status">
<tr>
 <td align="center"><s:property value="#status.count"/></td>
 <td align="center"><s:property value="StudentName"/></td>
 <td align="center"><s:property value="@com.csai.db.StudentUtil@havaSplitSpec(SpecialityId)"/></td>
 <td align="center"><s:property value="MatriNo"/></td>
 <td align="center">
 	<a href="Matri.action?action=del&studentid=<s:property value="StudentId"/>">ɾ��</a>
 </td>
</tr>
</s:iterator>
<tr>
<td align="center" colspan="5">
<font color="#0000FF">
	<s:if test="#request.pagecount>1&&#request.currentpage>1">
		<a href="Matri.action?currentpage=1&action=<s:property value="action"/>
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">��ҳ</a>
		<a href="Matri.action?currentpage=<s:property value="#request.currentpage-1" />
			&action=<s:property value="action" />
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">��һҳ</a>
	</s:if>
	<s:if test="#request.pagecount>1&&#request.currentpage<#request.pagecount">
		<a href="Matri.action?currentpage=<s:property value="#request.currentpage+1" />
			&action=<s:property value="action" />
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">��һҳ</a>
		<a href="Matri.action?currentpage=<s:property value="#request.pagecount" />
			&action=<s:property value="action"/>
			&specialityid=<s:property value="SpecialityId" />
			&studentname=<s:property value="StudentName" />">βҳ</a>
	</s:if>
	��<s:property value="#request.recount"/>����¼,
	��<s:property value="#request.pagecount"/>ҳ,
	��ǰ��<s:property value="#request.currentpage" />ҳ
</font>
</td>
</tr>
</table>
</s:form>
</body>
</html>