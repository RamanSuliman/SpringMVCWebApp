<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Employees Data</title>
</head>
<body>	
	<h1>Employees</h1>
	<table border="2" width="70%" cellpadding="2">  
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>  
	    <c:forEach var="emp" items="${list}">   
		    <tr>  
			    <td>${emp.id}</td>  
			    <td>${emp.name}</td>  
			    <td>${emp.salary}</td>   
			    <td><a href="editForm/${emp.id}">Edit</a></td>  
			    <td><a href="deleteEmployee/${emp.id}">Delete</a></td>  
		    </tr>  
	    </c:forEach>  
    </table>  
    
    <br/> 
    <a href="/SpringMVCWebApp/pagination/1">1</a>
    <a href="/SpringMVCWebApp/pagination/2">2</a>
    <a href="/SpringMVCWebApp/pagination/3">3</a>
    
    <br/><br/><br/> 
    <a href="addEmployee">Add New Employee</a>  
</body>
</html>