<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.util.*"%>
<html>
<head>
<title>Ventas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<c:choose>
		<c:when test="${not empty requestScope.ventas}">
			<h1>Compras de ${sessionScope.clienteLogado.usuario}</h1>
			<table border="1">
			    <tr><th>Libro</th><th>Fecha</th></tr>		
			    <c:forEach var="venta" items="${requestScope.ventas}">    	
		    		<tr>
		    			<td>${venta.libro.titulo}</td>
						<td>${venta.fecha}</td>						
					</tr>
				</c:forEach>			    	
			</table>
		</c:when>
		<c:otherwise>
			<h1>El cliente no tiene operaciones.</h1>
		</c:otherwise>
	</c:choose>    
<br/><br/>
<a href="Controller?op=doTemas">Volver</a>
</body>
</html>