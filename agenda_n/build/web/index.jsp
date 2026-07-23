<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrar</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form action="" method="post">
            <input type="text" name="usuario" id="usuario" placeholder="Usuário" required >
            <br><br>
            
            <input type="password" name="senha" id="senha" placeholder="Senha" required >
            <br><br>
            
            <input type="submit" value="Entrar">
            <br><br>
            
            <span>Não tem cadastro?</span>
            <a href="registro-usuario.jsp">Cadastre-se aqui!</a>
            
        </form>
    </body>
</html>
