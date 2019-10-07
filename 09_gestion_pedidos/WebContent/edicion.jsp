<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Controlador?op=hacerModificar" method="post">
		<input type="hidden" name="idPedido" value="${requestScope.pedido.idPedido}"/>
		Producto:<input type="text" name="producto" value="${requestScope.pedido.producto}"/>
		Precio: <input type="text" name="precio" value="${requestScope.pedido.precio}"/>
		Categoria: <input type="text" name="categoria" value="${requestScope.pedido.categoria}"/>
		<input type="submit" value="Modificar"/>
	</form>
	</center>
	<br/><br/>	
	<a href="Controlador?op=hacerListaPedidos">Volver</a>
</body>
</html>