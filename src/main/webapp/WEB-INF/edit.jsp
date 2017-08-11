<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><c:out value="${language.name}"/></title>
</head>
<body>
	<p><a href="/languages">Dashboard</a></p>
	
	<form:form method="POST" action="/languages/edit/${language.id}" modelAttribute="language">
	    <form:hidden path="id"/>
	    
	    <form:label path="name">Name: 
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    <br><br>
	    
	    <form:label path="creator">Creator: 
	    <form:errors path="creator"/>
	    <form:input path="creator"/></form:label>
	    
	    <br><br>
	    
	    <form:label path="currentVersion">Version: 
	    <form:errors path="currentVersion"/>
	    <form:input path="currentVersion"/></form:label>
	    
	    <br><br>
	    
	    <input type="submit" value="Submit"/>
	</form:form>
	
	<p><a href="/languages/delete/${language.id}">Delete</a></p>
</body>
</html>