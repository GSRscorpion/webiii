<%@page import="model.Agendamento"%>
<%@page import="database.AgendamentoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%
Usuario u = new Usuario();
ArrayList<Agendamento> list = new ArrayList();

if( session.getAttribute("userLogged") == null ){
    response.sendRedirect("index.jsp");
} else {
    u = (Usuario)session.getAttribute("userLogged");
    AgendamentoDAO dao = new AgendamentoDAO();
    list = dao.selecionaPorUsuario(u.getIdUsuario());
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Início </title>
    </head>
    <body>
        <h1>Bem vindo <%= u.getNomeUsuario() %>!</h1>
        <button type="button" onclick="window.location.href='UsuarioController?flag=sair'"> Sair </button>
        
        <button type="button" onclick="window.location.href='edita-usuario.jsp'"> Editar </button>
        
        <h2>Telefone: <%= u.getTelefoneUsuario() %> </h2>
        <a href="registro-agenda.jsp"> Novo agendamento </a>
    
        <hr>
        
        <table>
          <thead>
          <th> Data </th>
          <th> Descrição </th>
          </thead>
         <tbody>
        
        <%for(Agendamento a : list) { %>
         <tr>
          <td> <%= a.getDataAgendamento() %> </td>
          <td> <%= a.getDescAgendamento() %> </td>
          <td> <a href="#"> Editar </a> </td>
          <td> <a href="#" onclick="excluiAgenda('<%= a.getDescAgendamento() %>', '<%= a.getIdAgendamento() %>')"> Excluir </a>  </td>
         </tr>6
        <% } %>
        
         </tbody>
        </table>
        
        <script>
            function excluiAgenda(desc, id){
                if( confirm("Excluir a agenda para " + desc + "?") ){
                    window.location.href="AgendamentoController?flag=excluir&id=" + id
                }
            }
        </script>
        
    </body>
</html>
