<%@ page isELIgnored="false" %> <!-- Open EL command -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Welcome</title>
	</head>
	
	<body>
		
		<!-- C1 -->
		<font color="red">
			Welcome, ${sessionScope.account.username}
		</font>

		<!-- C2 -->
		<font color="blue">
			Welcome, <bean:write name="account" property="username"/>
		</font>

		<h1>Welcome page</h1>

		<br>
		<html:link action="/searchPage.do">Search user!</html:link>
		
		<br>
		<html:link action="/logout.do">Logout!</html:link>

	</body>
</html>