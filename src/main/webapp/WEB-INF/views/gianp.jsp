<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Gianp Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<%
		out.print("<h1>Messaggi Gianp</h1>");
	%>
	<hr>
	Ciao! Benvenuto in messaggi Gianp!
	<br> Data e ora :
	<%=new java.util.Date()%>
	<hr>

	<h3>Lista Messaggi</h3>
	<c:if test="${!empty listGianps}">
		<table class="tg">
			<tr>
				<th width="80">id</th>
				<th width="120">Messaggio</th>
				<th width="120">Modifica Messaggio</th>
				<th width="60">Cancella</th>
			</tr>
			<c:forEach items="${listGianps}" var="gianp">
				<tr>
					<td>${gianp.idgianp}</td>
					<td>${gianp.message}</td>
					<td><c:url var="addAction" value='/edit/${gianp.idgianp}'></c:url>
					<form:form action="${addAction}" commandName="gianp">
						<form:input path="message" />
						<input type="submit"
							value="<spring:message text="Modifica"/>" />
					</form:form></td>
					<td><a href="<c:url value='/remove/${gianp.idgianp}' />">Cancella</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


	<c:url var="addAction" value="/gianp/add"></c:url>

	<form:form action="${addAction}" commandName="gianp">
		<table>
			<tr>
				<td><form:label path="message">
						<spring:message text="Messaggio:" />
					</form:label></td>
				<td><form:input path="message" /></td>
			</tr>
			<tr>
				<td colspan="2">
						<input type="submit"
							value="<spring:message text="Crea messaggio"/>" />
					</td>
			</tr>
		</table>
	</form:form>

</body>
</html>
