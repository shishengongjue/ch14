<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form method="post" action="Speciality" theme="simple">
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="600">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center">	
	<font color="#0000FF">¼��רҵ����</font>
</td>
</tr>
<tr>
	<td width="100%">
	������רҵ����:
	<s:textfield name="specialityname" />
	<s:hidden name="action" value="add" />
	<s:submit value="�ύ"/>
	</td>
</tr>
</table>
</s:form>
<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:collapse"
	bordercolor="#C0C0C0" width="600">
<tr>
	<td width="100%" bgcolor="#C0C0C0" align="center" colspan="3">	
	<font color="#0000FF">����רҵ����</font>
</td>
</tr>
<tr>
	<td width="20%" align="center">���</td>
	<td width="60%" align="center">רҵ����</td>
	<td width="20%" align="center">ɾ��?</td>
</tr>
<s:iterator value="#request.specialityArray" status="status">
<tr>
	<td width="20%" align="center"><s:property value="#status.count" /></td>
	<td width="60%" align="center"><s:property value="SpecialityName" /></td>
	<td width="20%" align="center">
		<a href="Speciality.action?action=del&specialityid=<s:property value="SpecialityId"/>">
		ɾ��?</a>
	</td>
</tr>
</s:iterator>
</table>
</body>
</html>