<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<c:set var="contactos" value="${requestScope.contactos}"/>
	<c:choose>
		<c:when test="${!empty contactos}">
			<table border="1">
				<tr>
					<th>Nombre</th><th>Email</th><th>Edad</th>
				</tr>
				<c:forEach var="con" items="${contactos}" varStatus="v">
					<tr>
						<td>${con.nombre}</td>
						<td>${con.email}</td>
						<td>${con.edad}</td>
						<td><a href="Controller?op=doEliminarPorId&idContacto=${con.idContacto}">Eliminar</a></td>
						<td>${v.index+1}</td>
					</tr>
				</c:forEach>
			</table>	
		</c:when>
		<c:otherwise>
			<h1>No hay contactos</h1>
		</c:otherwise>
	</c:choose>
	<br/>
	<a href="Controller?op=toMenu">Volver</a>
</body>
</html>