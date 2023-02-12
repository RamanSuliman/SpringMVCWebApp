<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Mail State! </h1>
	<h2> Mail from ${mail.from} to ${mail.to} with subject of: ${mail.subject} hsa been sent! </h2>
	<h3> Message: ${mail.message} </h3>
</body>
</html>