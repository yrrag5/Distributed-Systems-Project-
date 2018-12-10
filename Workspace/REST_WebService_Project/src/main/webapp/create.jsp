<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Booking</title>
</head>
<body>
	<h2>Create a booking</h2>
	
	<form action="webapi/myresource/create" method="post">
	  <p>Enter Booking ID :</p>
    	<input type="number" name="bId"/>
    <p>Enter Customer ID :</p>
    	<input type="number" name="cId"/>
    <p>Enter Registration Number :</p>
    	<input type="text" name="rId"/>
    <p>Enter Booking Date :</p>
    	<input type="date" name="sDate" />
    <p>Enter Return Date :</p>
    	<input type="date" name="eDate" />
   	 	<input type="submit" value="Submit"/>
    </form>
	
	<p><a href="index.jsp">Return to main menu</a></p>

</body>
</html>