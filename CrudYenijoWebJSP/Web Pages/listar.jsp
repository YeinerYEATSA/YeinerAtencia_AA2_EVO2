<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, com.crud.modelo.Usuario" %>
<%
    List<Usuario> lista = (List<Usuario>) request.getAttribute("usuarios");
%>
<html>
<head><title>Listado de Usuarios</title></head>
<body>
<h1>Usuarios</h1>
<a href="UsuarioServlet?accion=nuevo">Agregar Nuevo</a>
<table border="1">
    <tr><th>ID</th><th>Nombre</th><th>Email</th><th>Teléfono</th><th>Acciones</th></tr>
    <% for (Usuario u : lista) { %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getNombre() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getTelefono() %></td>
            <td>
                <a href="UsuarioServlet?accion=editar&id=<%= u.getId() %>">Editar</a> |
                <a href="UsuarioServlet?accion=eliminar&id=<%= u.getId() %>" onclick="return confirm('¿Está seguro?')">Eliminar</a>
            </td>
        </tr>
    <% } %>
</table>
</body>
</html>
