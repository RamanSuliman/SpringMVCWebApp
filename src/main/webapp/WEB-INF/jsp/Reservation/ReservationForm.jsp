<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>  
<html>  
<head>  
    <title>Reservation Form</title>  
</head>  
	<h3>Reservation Form</h3>  
<body>  
    <form:form action="submitReservationForm" modelAttribute="reservationObject">  
        First name: <form:input path="firstName" />         
        <br><br>  
        Last name: <form:input path="lastName" />  
        <br><br>
        Gender:
        Male <form:radiobutton path="gender" value="Male"/>
        Female <form:radiobutton path="gender" value="Female"/>    
        <br><br>  
        Meals:
        Breakfast <form:checkbox path="food" value="Breakfast"/>
        Lunch <form:checkbox path="food" value="Lunch"/>
        Dinner <form:checkbox path="food" value="Dinner"/>
        <br><br>
        From Location:
        <form:select path="cityFrom">
       		<form:option value="Manchester" label="Manchester"/>
       		<form:option value="London" label="London"/>
       		<form:option value="Liverpool" label="Liverpool"/>
        </form:select>
        <br><br>
        To Location:
        <form:select path="cityTo">
       		<form:option value="Manchester" label="Manchester"/>
       		<form:option value="London" label="London"/>
       		<form:option value="Liverpool" label="Liverpool"/>
        </form:select>
        <br><br>
        <input type="submit" value="Submit" />  
    </form:form>  
</body>  
</html> 