<%
String flag = "";
if( request.getAttribute("flag") != null ) {
    flag = (String)request.getAttribute("flag");
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <form action="UsuarioController" method="post">
            <input type="hidden" name="flag" value="login">
            
            <input type="text" name="usuario" id="usuario" placeholder="Usuário" required >
            <br><br>
            <input type="password" name="senha" id="senha" placeholder="Senha" required >
            <br><br>
            <input type="submit" value="Entrar">
            <br><br>
            <span>Não tem uma conta? </span>
            <a href="registro-usuario.jsp"> Cadastre-se aqui!</a>
        </form>
        
        <%
        if(request.getAttribute("flag") != null) {
            if( flag.equals("ok") ) {
                out.print("<script>"
                        + "alert('Usuário registrado com sucesso!')"
                        + "</script>");
            } else {
                out.print("<script>"
                        + "alert('Ocorreu algum erro :( ')"
                        + "</script>");
            }
        }
        
        if( request.getAttribute("autenticado") != null &&
                !(boolean)request.getAttribute("autenticado")){
            out.print("<script>"
                    + "alert('Usuário ou senha incorretos.')"
                    + "</script>");
        }
        %>
        
    </body>
</html>
