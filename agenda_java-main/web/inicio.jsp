<%@page import="model.Usuario"%>
<%
Usuario u = new Usuario();
    
if( session.getAttribute("userLogged") == null ){
    response.sendRedirect("index.jsp");
} else {
    u = (Usuario)session.getAttribute("userLogged");
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>inicio</title>
    </head>
    <body>
        <h1>Bem vindo <%= u.getNomeUsuario() %>!</h1>
        <button type="button" onclick="window.location.href='UsuarioController?flag=sair'"> Sair </button>
        
        <button type="button" onclick="window.location.href='edita-usuario.jsp'"> Editar dados</button>
        
        <h2>Telefone: <%= u.getTelefoneUsuario() %> </h2>
        
        <a href="regiatro-agenda.jsp">Novo agendamento</a>
    </body>
</html>
