<%@page import="database.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page import="java.sql.SQLException"%>
<%
Usuario user = new Usuario();
user.setNomeUsuario("Ferran Torres");
user.setTelefoneUsuario("2345678");
user.setSenhaUsuario("senha123");

try {
    UsuarioDAO ud = new UsuarioDAO();
    ud.novoUsuario(user);
} catch(ClassNotFoundException | SQLException e) {
    System.err.println(e);
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
