<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle Artista</title>
</head>
<body>
    <h1>Detalle Del Artista</h1>
    <p>Nombre: ${artista.nombre}</p>
    <p>Apellido: ${artista.apellido}</p>
    <p>Biografia: ${artista.biografia}</p>
    <h2>Canciones del Artista</h2>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
            <li>
                <h3>${cancion.titulo}</h3>
                <p>Album: ${cancion.album}</p>
                <p>Genero: ${cancion.genero}</p>
                <p>Idioma: ${cancion.idioma}</p>
            </li>
        </c:forEach>
    </ul>
    <a href="/artistas">Volver a Lista de Artistas</a>
</body>
</html>