<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Booking</title>
</head>
<body>

<h2> Delete A Booking</h2>
<form action="webapi/myresource/delete" method="post">
		<p> Enter Booking ID to be deleted
    	<input type="number" name="bId" />
   	 	<input type="submit" value="Delete"/>
    </form>
    <p><a href="index.jsp">Return to main menu</a></p>

</body>
</html>