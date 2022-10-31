<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Register</title>
	</head>
	
	<body>
		
		<html:link action="/home.do">Home page</html:link>

		<br>
			<logic:present name="message">
				<bean:write name="message" />
			</logic:present>
		<br>
		
		<!-- Sau khi nhập data, POST request này sẽ thực hiện call Action "/registerCheck.do" để thực hiện quá trình Register (INSERT data) -->
		<html:form action="/registerCheck.do" method="post">

			<br>
			
			<label>Name</label>
			<html:text property="name" name="userForm"></html:text>
			<html:errors property="name"/>
			
			<br>
			
			<label>Age</label>
			<html:text property="age" name="userForm"></html:text>
			<html:errors property="age"/>

			<br>
			
			<html:submit>Add User!</html:submit>
			
		</html:form>
		
	</body>
</html>
