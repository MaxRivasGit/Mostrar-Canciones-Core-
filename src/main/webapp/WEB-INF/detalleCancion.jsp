<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Detalle de la Canción</h1>

            <li>
            <h2>${cancion.titulo}</h2>
            <p>Artista: ${cancion.artista}</p>
            <p>Álbum: ${cancion.album}</p>
            <p>Género: ${cancion.genero}</p>
            </li>

            <button> <a href="<c:url value='/canciones' />">Volver</a></button>

</body>
</html>