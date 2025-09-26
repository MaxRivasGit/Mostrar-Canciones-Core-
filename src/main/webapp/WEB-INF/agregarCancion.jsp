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
        <form:errors path="titulo" cssClass="error"/>
        <br/>

        <label for="artista">Artista:</label>
        <form:input path="artista" id="artista"/>
        <form:errors path="artista" cssClass="error"/>
        <br/>

        <label for="album">Album:</label>
        <form:input path="album" id="album"/>
        <form:errors path="album" cssClass="error"/>
        <br/>

        <label for="genero">Genero:</label>
        <form:input path="genero" id="genero"/>
        <form:errors path="genero" cssClass="error"/>
        <br/>

        <label for="idioma">Idioma:</label>
        <form:input path="idioma" id="idioma"/>
        <form:errors path="idioma" cssClass="error"/>
        <br/>

        <button type="submit">Agregar Cancion</button>
        </div>
    </form:form>

    <a href="/canciones">Volver a Lista de Canciones</a>
</body>
</html>