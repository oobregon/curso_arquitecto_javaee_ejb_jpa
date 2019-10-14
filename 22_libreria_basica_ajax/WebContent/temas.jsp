<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Temas y libros</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

	function enviarPeticion(idTema) {
		var url = "Controlador?op=hacerListaLibros&idTema=" + idTema; 
		$.get(url,function(respuesta,estado) {
			procesarRespuesta(respuesta);
		});	
	}
	
	function procesarRespuesta(respuesta) {		
		var json = JSON.parse(respuesta);
		var tabla = "<br/><table border='1'><tr><th>Titulo</th><th>Autor</th><th>Precio</th><th>Paginas</th></tr>"
		for(var i=0;i<json.length;i++) {
			tabla+="<tr><td>" + json[i].titulo + "</td>";
			tabla+="<td>" + json[i].autor + "</td>";
			tabla+="<td>" + json[i].precio + "</td>";
			tabla+="<td>" + json[i].paginas + "</td></tr>";
		}
		tabla+= "</table>";
		$("#tablaLibros").html(tabla);
	}
	
</script>
</head>
<body>
	Nombre: <input type="text" name="nombre" value="Hernán" /><br/><br/>
	Apellidos: <input type="text" name="nombre" value="Cortés" /><br/><br/>
	Temas:<select id="tema" onchange="enviarPeticion($('#tema').val());">
		<option value="0">Todos</option>
		<c:forEach var="tema" items="${requestScope.temas}">
			<option value="${tema.idTema}">${tema.tema}</option>				
		</c:forEach>				
	</select>
	<div id="tablaLibros">
	</div>
</body>
</html>