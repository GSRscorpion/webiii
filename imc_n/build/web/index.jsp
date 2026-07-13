<%@page import="model.Dados"%>
<%
    Dados imc = new Dados();
    if(request.getAttribute("imc") != null){
        imc = (Dados)request.getAttribute("imc");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>imc - Calculadora</title>
    </head>
    <body>
        <h1>Calculadora IMC</h1>
        <form action="CalculoController" method="post">
            <label>Peso(kg):</label><br>
            <input type="number" id="peso" name="peso" step="0.001"  placeholder="EX: 70.123" min="0.001" required>
            <br><br>
            <label>altura(m²):</label><br>
            <input type="number" id="altura" name="altura" step="0.01"  placeholder="EX: 1.60" min="0.01" required>
            <br><br>
            <input type="submit" value="Calcular">
            <input type="reset" value="Limpar">
        </form>
        
        <%
          if((request.getAttribute("imc") != null)){
              out.print(imc);
          }
        %>
        
    </body>
</html>
