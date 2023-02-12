<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="feedback" modelAttribute="mail">
		<p> T0: <form:input path="to" placeholder="To email..."/> </p>
		<br>
		<p> Subjet: <form:input path="subject" placeholder="Subjet name..."/> </p>
		<br>
		<p> Message: <form:textarea path="message" placeholder="Message body..."/> </p>
		<input type="submit" value="Send >>>">
	</form:form>
</body>
</html>