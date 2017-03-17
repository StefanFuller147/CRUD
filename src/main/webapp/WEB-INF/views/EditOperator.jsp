<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Editing "${Operator.codeName} "</title>
</head>
<body>
<h1>Editing ${Operator.codeName}</h1>
	<a href="http://localhost:8080/C.R.U.D/GetOperatorData.do?">Back to home page</a>
	<form action="EditOperatorData.do" method="POST">
		<input type="hidden" name="id" value="${Operator.id }"/><br>
		Operator's First Name: <input type="text" name="firstName" value="${Operator.firstName}"/><br>
		Operator's Last Name: <input type="text" name="lastName" value="${Operator.lastName}"/><br>
		Operator CTU: <input type="text" name="nationality" value="${Operator.nationality}"/><br> 
		Operator Side: <input type="text" name="side" value="${Operator.side}"/><br> 
		Operator Codename: <input type="text" name="codeName" value="${Operator.codeName}"/><br> 
		<button type="submit" value="Edit Operator">Save changes to ${Operator.codeName}</button>
		
	</form>
</body>
</html>