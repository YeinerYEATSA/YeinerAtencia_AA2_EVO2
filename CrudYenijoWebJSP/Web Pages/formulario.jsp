<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.crud.modelo.Usuario" %>
<%
    Usuario u = (Usuario) request.getAttribute("usuario");
    if (u == null) {
        u = new Usuario();
    }
%>
<html>
<head><title>Formulario Usuario</title></head>
<body>
<h2><%= (u.getId() == 0) ? "Agregar" : "Editar" %> Usuario</h2>
<form method="post" action="UsuarioServlet">
    <input type="hidden" name="id" value="<%= u.getId() %>"/>
    Nombre: <input type="text" name="nombre" value="<%= u.getNombre() %>" required/><br/>
    Email: <input type="email" name="email" value="<%= u.getEmail() %>" required/><br/>
    Teléfono: <input type="text" name="telefono" value="<%= u.getTelefono() %>" required/><br/>
    <input type="submit" value="Guardar"/>
</form>
<a href="UsuarioServlet">Volver</a>
</body>
</html>
