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
AccountSessionForm accountSession = (AccountSessionForm) request.getSession().getAttribute("accountSession");

if(accountSession == null) {
	accountSession = new AccountSessionForm();
	// accountSession.setLastmsg("Session Expired! Please login again!");
	
	response.sendRedirect("pages/sessionExpired.jsp");
	
	String messageExpired = accountSession.getLastmsg();
	%>
<%=messageExpired %>
<%
}
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Search</title>
	</head>
	
	<body>
		
		<br>
		<font color="red">
			Welcome, ${sessionScope.account.username}
		</font>

		<h1>Search page</h1>

		<html:form action="/searchProcess.do" method="post" >
		
			<label>Search username value</label>
			<html:text property="searchValue" name="searchBean"/>
			
			<br>
			<html:submit>Find</html:submit>
		</html:form>
		
		<bean:define id="customBean" property="value" value="${requestScope.searchBean.searchValue}" type="java.lang.String" toScope="request" />
		<!-- c:set var="searchValue" value="${requestScope.search.searchValue}" -->

		<logic:notEmpty name="customBean">
		
			<table border="1" cellpadding="2" cellspacing="2">
			
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Options</th>
				</tr>
				
				<logic:iterate name="listAccounts" id="listAccountsId">
					<tr>
						<td><bean:write name="listAccountsId" property="username"/></td>
						<td><bean:write name="listAccountsId" property="password"/></td>
						
						<td>
							<html:link action="/getAccount.do" paramName="listAccountsId" paramId="username" paramProperty="username"> Update </html:link>
							|
							<html:link action="/deleteAccount.do" paramName="listAccountsId" paramId="username" paramProperty="username" onclick="return confirm('Are you sure?')"> Delete </html:link>
						</td>
					</tr>
				</logic:iterate>
			
			</table>
		
		</logic:notEmpty>

	</body>
</html>
