<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>
	<center>		
            <h1>Seleccione Tema</h1>
            <br/><br/>
		<form  action="Controller?op=doLibros" method="post">
			<select name="tema">
				<option value="0">Todos</option>						
				<c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema}">${t.tema}</option>		    		
				</c:forEach>								
			</select>
			<br/><br/>
			<input type="submit" value="Ver libros"/>			
		</form>
	</center>
	<br/><br/>
	<a href="Controller?op=doVentas">Mis compras</a>
	<br/><br/>
	<a href="Controller?op=doCerrarSesion">Cerrar sesión</a>
</body>
</html>