<%@ page isELIgnored="false" %> <!-- Open EL command -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%@page import="Siirex.model.AccountSessionForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + path + "/";
%>

<%
AccountSessionForm accountSession = (AccountSessionForm) request.getSession(false).getAttribute("accountSession");
if(accountSession == null) {
	accountSession = new AccountSessionForm();
	accountSession.setLastmsg("Session Expired! Please login again!");
	String messageExpired = accountSession.getLastmsg();
	%>
<%=messageExpired %>
<%
}
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Session Expired</title>
		<base href="<%=basePath %>">
	</head>
	
	<body>
		<br>
		<html:link action="/controller.do">Login!</html:link>
	</body>
</html>
