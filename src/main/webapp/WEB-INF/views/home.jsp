<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1 id="head">
		<a href="http://localhost:8080/C.R.U.D/GetOperatorData.do?">Operators</a>
	</h1>
	<c:if test="${operatorList != null}">
	<c:forEach var="operator" items="${operatorList}">
		<a href="GetOperatorData.do?id=${operator.id}">${operator.firstName} <em>"${operator.codeName} "</em> ${operator.lastName}</a>
		<br>
	</c:forEach>
	<div>
		<form action="AddAnOperatorForm.do" method="POST">
		<button type="submit">Add an Operator</button>
		</form>
	</div>
	</c:if>
	<c:if test="${Operator != null}">
	<div id="back">
		<a href="GetOperatorData.do?back=back&id=${Operator.id}">Previous Operator</a>
	</div>
	
	<div id="next">
		<a href="GetOperatorData.do?next=next&id=${Operator.id}">Next Operator</a>
	</div>
	<div>
		<!--Operator ID: ${Operator.id}<br>-->
		Name: ${Operator.firstName }
		${Operator.lastName }<br>
		Operator codeName: ${Operator.codeName }<br>
		Member of the: "${Operator.nationality}" CTU <br>
		Attacker or Defender: ${Operator.side }<br>
		<img src="OperatorPics/${Operator.picture}"/> ${Operator.picture }${Operator.picture }
		<br>
		 <form action="goToEditForm.do" method="POST">
		 <button type="submit" name="id" value="${Operator.id}">Edit ${Operator.codeName}</button>
		 </form>
		 <form action="RemoveAnOperator.do" method="POST">
		<button type="submit" name="id" value="${Operator.id}">Remove ${Operator.codeName} from list</button>		 
		 </form>
		 
	</div>
	</c:if>
	

</body>
</html>
