<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.error{
			color: red;
		}
	</style>
</head>
<body>
	<h1>Login Form</h1>
	<form action="/SpringMVCWebApp/submitLoginNew" method="POST">
		<p>
			Username: <input type="text" name="username">
		</p>
		<p>
			password: <input type="password" name="password">
		</p>
		<input type="submit" value="Login">
	</form>
	
	<h1>Enhanced Form</h1>
	<form:form action="submitEnhancedForm" modelAttribute="user">
		<p>
			Username: <form:input path="name" id="name" class="form-control" placeholder="Username" autofocus="autofocus"/>
		</p>
		<p>
			password: <form:input path="password" type="password"/>
			<form:errors path="password" cssClass="error"/>
		</p>
		<input type="submit" value="Login">
	</form:form>
</body>
</html>