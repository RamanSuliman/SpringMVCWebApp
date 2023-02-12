<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<body>
	<p>Your reservation is confirmed successfully. Please, re-check the details.</p>  
	First Name : ${reservationObject.firstName} 
	<br>  
	Last Name : ${reservationObject.lastName}  
	<br>
	Gender : ${reservationObject.gender}
	<br><br>
	Meals:
	<ul>
		<c:forEach var="meal" items="${reservationObject.food}">  
			<li>${meal}</li>  
		</c:forEach>  
	</ul>
	Leaving From : ${reservationObject.cityFrom} 
	<br>  
	Going To : ${reservationObject.cityTo}  
</body>
</html>