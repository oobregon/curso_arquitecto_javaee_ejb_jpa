<%@page import="java.util.List"%>
<%@page import="model.Contacto"%>
<%@page import="daos.DaoContactosImp"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 	List<Contacto> agenda = (List<Contacto>)request.getAttribute("agenda"); %>
	
	<table border=1>
		<tr>
			<td>Id Contacto</td>
			<td>Nombre</td>
			<td>Email</td>
			<td>Edad</td>
		</tr>
		<% for(Contacto contacto:agenda) {	%>
		<tr>
			<td><%=contacto.getIdContacto() %></td>
			<td><%=contacto.getNombre() %></td>
			<td><%=contacto.getEmail() %></td>
			<td><%=contacto.getEdad() %></td>
			<td><a href="Controlador?op=doEliminar&idContacto=<%=contacto.getIdContacto() %>">Eliminar</a></td>
		</tr>	
		<% } %>
	</table>
	<br/><br/>	
	<a href="Controlador?op=toEntrada">Volver</a>
</body>
</html>