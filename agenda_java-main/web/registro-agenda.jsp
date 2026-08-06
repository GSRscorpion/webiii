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
        <title>Novo agendamento</title>
    </head>
    <body>
        <h1>Novo agendamento</h1>
        <form action="AgendamentoController" method="post">
            <input type="hidden" name="flag" value="salvar">
            
            <input type="datetime-local" name="data-agenda" id="data-agenda" required >
            <br><br>
            
            <textarea id="desc" name="desc" rows="3" cols="40" placeholder="Descreva o serviço solicitado..." ></textarea>            
            
            <br><br>
            <input type="submit" value="Agendar">
            <br><br>
            
            <a href="inicio.jsp"> Voltar </a>
        </form>
        
    </body>
</html>
