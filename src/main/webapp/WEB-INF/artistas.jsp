<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Artistas</title>
</head>
<body>
    <h1>Lista de Artistas</h1>
    <ul>
        <c:forEach var="artista" items="${artistas}">
            <li>
                <a href="/artistas/detalle/${artista.id}">
                    ${artista.nombre} ${artista.apellido}
                </a>
            </li>
        </c:forEach>
    </ul>
    <a href="/canciones">Ir a Canciones</a>
</body>
</html>