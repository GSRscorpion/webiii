 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
    </head>
    <body>
        <h1>Cadastro de novo usuário</h1>
        
        <form action="UsuarioControlller" method="post">
            
            <input type="hidden" name="flag" value="salvar">
            
            <input type="text" name="usuario" id="usuario" placeholder="Usuário" required >
            <br><br>
            
            <input type="text" name="telefone" id="telefone" placeholder="Telefone" required >
            <br><br>
            
            <input type="password" name="senha" id="senha" placeholder="Senha" required >
            <br><br>
            
            <input type="password" name="senha-conf" id="senha-conf" placeholder="Confirme a senha" required >
            <br><br>
            
            <input type="submit" value="Cadastrar">
            <br><br>
            
            <span>já tem cadastro?</span>
            <a href="index.jsp">Faça login aqui!</a>
            
        </form>
    </body>
</html>
