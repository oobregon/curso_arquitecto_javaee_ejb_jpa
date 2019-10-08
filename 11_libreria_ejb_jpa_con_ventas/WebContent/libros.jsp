<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.util.*"%>

<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<c:choose>
		<c:when test="${not empty requestScope.libros}">
			<table border="1">
			    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		
			    <c:forEach var="lib" items="${requestScope.libros}">    	
		    		<tr>
		    			<td>${lib.titulo}</td>
						<td>${lib.autor}</td>
						<td>${lib.precio}</td>
					</tr>
				</c:forEach>			    	
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay libros</h1>
		</c:otherwise>
	</c:choose>    
<br/><br/>
<a href="Controller?op=doTemas">Otro tema</a>
</body>
</html>