<%-- 
    Document   : inicio
    Created on : 08-26-2020, 01:54:50 AM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro alumno</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Registro de Alumno</h1>
        <br>        <br>
        <form action="RegistroServlet1" method="post">
        Nombre: <input type="text" id="name" name="name">
        <br>        <br>
        Carrera: 
            <select id="Carrera" name="Carrera" required>

                <option value="2">Licenciatura en Ciencias Jurídicas</option>
                <option value="3">Licenciatura en Economía</option>
                <option value="1">Ingeniería en Negocios</option>
                <option value="4">Primer año</option>
            </select>
        
        <br>        <br>
        Año:
            <select id="agno" name="agno" required>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        <br>        <br>
        Carnet: <input type="text" id="name" name="carnet">
        <br>        <br>
        Correo: <input type="text" id="name" name="correo">
        <br>        <br>
        Contraseña <input type="password" id="name" name="contrasegna">
        <br><br>
                
        <input type="submit" value="Entrar"/>
        <input type="hidden" id="formid" name="formid" value="1"/>
        </form>
    </body>
</html>