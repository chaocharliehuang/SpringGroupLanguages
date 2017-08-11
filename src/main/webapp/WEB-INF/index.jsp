<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Languages</title>
	<style>
		table {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 8px;
		}
		
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
	</style>
</head>
<body>
	<c:if test="${!empty languages}">
		<table>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${languages}" var="language" varStatus="loop">
			<tr>    
			    <td>
			    		<a href="/languages/${language.id}"><c:out value="${language.name}"/></a>
			    </td>
			    <td><c:out value="${language.creator}"/></td>
			    <td><c:out value="${language.currentVersion}"/></td>
			    <td>
			    		<a href="/languages/edit/${language.id}">Edit</a> | 
			    		<a href="/languages/delete/${language.id}">Delete</a>
			    </td>
			</tr>
			</c:forEach>
		</table>
		<br><br>
	</c:if>
	
	<form:form method="POST" action="/languages/new" modelAttribute="language">
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
</body>
</html>