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
        <title>Editar</title>
    </head>
    <body>
        <h1>Editar usuário</h1>
        <form action="UsuarioController" method="post" onsubmit="return confirm('Confirma a alteração dos dados?')">
            <input type="hidden" name="flag" value="editar">
            <input type="hidden" name="id" value="<%= u.getIdUsuario() %>">
            
            <input type="text" name="usuario" id="usuario" value="<%= u.getNomeUsuario() %>" readonly >
            <br><br>
            <input type="text" name="telefone" id="telefone" placeholder="Nº de telefone" value="<%= u.getTelefoneUsuario() %>" required >
            <br><br>
            
            <div>
                <input type="password" name="senha" id="senha" placeholder="Nova senha" required >
                <button id="btn-senha" type="button">Mostrar</button>
            </div>
            
            <br>
            
            <div>
                <input type="password" name="senha-conf" id="senha-conf" placeholder="Confirme a senha" required >
                <button id="btn-senha-conf" type="button">Mostrar</button>
            </div>
            
            <br><br>
            <input type="submit" value="Editar">
            <br><br>
            
            <a href="#" onclick="excluir()">Excluir conta</a>
        </form>
        
        <script>
            const senha = document.getElementById("senha");
            const senhaConf = document.getElementById("senha-conf");
            const btnSenha = document.getElementById("btn-senha");
            const btnSenhaConf = document.getElementById("btn-senha-conf");
            
            console.log(btnSenha);
            
            btnSenha.addEventListener("click", ()=>{
                if( senha.type === "text" ) {
                    senha.type = "password";
                    btnSenha.innerHTML = "Mostrar";
                } else {
                    senha.type = "text";
                    btnSenha.innerHTML = "Esconder";
                }
            });
            
            btnSenhaConf.addEventListener("click", ()=>{
                if( senhaConf.type === "text" ) {
                    senhaConf.type = "password";
                    btnSenhaConf.innerHTML = "Mostrar";
                } else {
                    senhaConf.type = "text";
                    btnSenhaConf.innerHTML = "Esconder";
                }
            });
            
            function excluir() {
                if( confirm("Deseja excluir sua conta? Esta operação é irreversível!") ){
                    window.location.href="UsuarioController?flag=excluir&id=<%= u.getIdUsuario() %>"
                }
            }
        </script>
        
    </body>
</html>
