<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Operator</title>
</head>
<body>
	<h1>Add your own operator</h1>
	<a href="http://localhost:8080/C.R.U.D/GetOperatorData.do?">Back to home page</a>

	<form action="AddAnOperator.do" method="POST">
		Operator's First Name: <input type="text" name="firstName"/><br>
		Operator's Last Name: <input type="text" name="lastName"/><br>
		Operator CTU: <input type="text" name="nationality"/><br> 
		OperatorSide: <input type="text" name="side"/><br> 
		Operator codeName: <input type="text" name="codeName"/><br>
		<button type="submit" value="Add Operator">Save changes</button>
	</form>
</body>
</html>