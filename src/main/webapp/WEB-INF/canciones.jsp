<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista Canciones</title>
</head>
<body>
    <h1>Lista de Canciones</h1>

        <ul>
    <c:forEach var="cancion" items="${canciones}">
        <li>
            <h2>${cancion.titulo}</h2>
            <p>Artista: ${cancion.artista}</p>
            <button>
                <a href="<c:url value='/canciones/detalle/${cancion.id}' />">Detalle</a>
            </button>
        </li>
    </c:forEach>
</ul>
    <a href="/canciones/formulario/agregar">Agregar Nueva Cancion</a>
    <a href="/artistas">Ir a Artistas</a>
</body>
</html>