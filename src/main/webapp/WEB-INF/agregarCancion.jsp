<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregando Cancion</title>
</head>
<body>
    <h1>Agregar Cancion</h1>

    <form:form method="POST" action="/canciones/procesa/formulario" modelAttribute="nuevaCancion">
        <div>
        <label for="titulo">Titulo:</label>
        <form:input path="titulo" id="titulo"/>
        <form:errors path="titulo"/>
        <br/>

        Artista:
        <select name="artistaId">
            <c:forEach items="${listaArtistas}" var="artista">
                <option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
            </c:forEach>
        </select><br>

        <label for="album">Album:</label>
        <form:input path="album" id="album"/>
        <form:errors path="album"/>
        <br/>

        <label for="genero">Genero:</label>
        <form:input path="genero" id="genero"/>
        <form:errors path="genero"/>
        <br/>

        <label for="idioma">Idioma:</label>
        <form:input path="idioma" id="idioma"/>
        <form:errors path="idioma"/>
        <br/>

        <button type="submit">Agregar Cancion</button>
        </div>
    </form:form>

    <a href="/canciones">Volver a Lista de Canciones</a>
</body>
</html>