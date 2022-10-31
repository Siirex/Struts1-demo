<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>HomePage</title>
	</head>
	
	<body>

		<html:link action="/register.do">Create new User</html:link>
		
		<br>
			<logic:present name="message">
				<bean:write name="message" />
			</logic:present>
		<br>

		<table border="1" cellpadding="2" cellspacing="2">
		
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Option</th>
			</tr>
			
			<logic:iterate name="allUser" id="allUserId">
				<tr>
					<td><bean:write name="allUserId" property="name"/></td>
					<td><bean:write name="allUserId" property="age" format="##########"/></td>
					
					<td>
						<html:link action="/getUser.do" paramName="allUserId" paramId="userId" paramProperty="id"> Update </html:link>
						|
						<html:link action="/deleteUser.do" paramName="allUserId" paramId="userId" paramProperty="id" onclick="return confirm('Are you sure?')"> Delete </html:link>
					</td>
					
				</tr>
			</logic:iterate>
		
		</table>
		
	</body>
</html>
