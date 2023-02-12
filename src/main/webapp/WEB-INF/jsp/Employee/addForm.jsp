<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Employee</title>
</head>
<body>
	<h1>Add New Employee</h1>  
       <form:form method="post" action="saveEmployee">    
	        <table>    
	        	<tr>    
			          <td>ID : </td>   
			          <td><form:input path="id"/></td>  
		         </tr>  
		         <tr>    
			          <td>Name : </td>   
			          <td><form:input path="name"/></td>  
		         </tr>    
		         <tr>    
			          <td>Salary :</td>    
			          <td><form:input path="salary" /> </td>  
		         </tr>   
		         <tr>    
			          <td> </td>    
			          <td><input type="submit" value="Save" /></td>    
		         </tr>    
	        </table>    
       </form:form>  
</body>
</html>