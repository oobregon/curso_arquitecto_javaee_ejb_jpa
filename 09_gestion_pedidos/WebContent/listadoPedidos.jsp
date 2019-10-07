<%@page import="java.util.List"%>
<%@page import="model.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>		
	<table border=1>
		<tr>
			<td>Id Pedido</td>
			<td>Producto</td>
			<td>Precio</td>
			<td>Categoria</td>
		</tr>
		<c:forEach var="pedido" items="${requestScope.pedidos}">				
		<tr>
			<td>${pedido.idPedido}</td>
			<td>${pedido.producto}</td>
			<td>${pedido.precio}</td>			
			<td>${pedido.categoria}</td>						
			<td><a href="Controlador?op=hacerEliminar&idPedido=${pedido.idPedido}">Eliminar</a></td>
			<td><a href="Controlador?op=hacerEditar&idPedido=${pedido.idPedido}">Editar</a></td>
		</tr>			
		</c:forEach>
	</table>
	<br/><br/>	
	<a href="Controlador?op=aFormMenu">Volver</a>
</body>
</html>