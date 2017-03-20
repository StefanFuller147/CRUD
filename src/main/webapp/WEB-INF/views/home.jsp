<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="java.io.*,java.nio.*, java.nio.channels.*"%>

<html>
<head>
<!-- <link rel="stylesheet" href="home.css">
 -->
<title>R6 Ops.${Operator.codeName}</title>
</head>
<body>

	<a class="homeButton" href="http://localhost:8080/C.R.U.D/">R6</a>
	<h2>${Operator.codeName}</h2>
	<div id="head">
		<h1></h1>

		</h1>
	</div>
	<c:if test="${operatorList != null}">
		<c:forEach var="operator" items="${operatorList}">
			<a href="GetOperatorData.do?id=${operator.id}">${operator.firstName}
				<em>"${operator.codeName} "</em> ${operator.lastName}
			</a>
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
			<a href="GetOperatorData.do?back=back&id=${Operator.id}">Previous
				Operator</a>
		</div>

		<div id="next">
			<a href="GetOperatorData.do?next=next&id=${Operator.id}">Next
				Operator</a>
		</div>
		<div id="opInfo">
			<!--Operator ID: ${Operator.id}<br>-->

			<div id="opName">Name: ${Operator.firstName } ${Operator.lastName }</div><br>
			<div id="codeName">Operator codeName: ${Operator.codeName }</div><br>
			<div id="ctu">Member of the: "${Operator.nationality}" CTU</div> <br>
			<div id="side">Attacker or Defender: ${Operator.side }</div><br>
			<div id="bio">Operator bio: ${Operator.bio}</div><br>
			<div id="opVideo">Operator video: ${Operator.operatorVideo }</div>


			<div id="opPhoto">
			 <img style="width: 25%"
				src="OperatorPics/${Operator.picture}" /> <img class="first" style="width: 20%"/></div>
				
				<div id="opIcon">
				<img src="OperatorIcons/${Operator.icon }" /></div> <br>
			<form action="goToEditForm.do" method="POST">
				<button type="submit" name="id" value="${Operator.id}">Edit
					${Operator.codeName}</button>
			</form>
			<form action="RemoveAnOperator.do" method="POST">
				<button type="submit" name="id" value="${Operator.id}">Remove
					${Operator.codeName} from list</button>
			</form>

		</div>
	</c:if>
</body>
</html>
