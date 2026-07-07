<%@page import="model.pedido"%>
<%
 //Scriptlet -Código java
 
//Capturando o objeto recebido

pedido p = (pedido) request.getAttribute("pedido");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"/>
        <title>Xis QI pedido</title>
    </head>
    <body>
        <h1>Finalize o pedido</h1>
        <h2>Confirme os dados do pedido</h2>
        
        <ul>
            <li>🍔 Sabor: <%= p.getSabor() %></li>
            <li>🍟 Acompanhamentos: <%= p.getTodosAcomp()%></li>
            <li>🥤 Bebidas: <%= p.getBebida() %></li>
            <li>🛵 Entrega: <%= p.getEntrega() %></li>
            <li>💵 Valor: <%= "$ " + p.getValor()%></li>
        </ul>
        <hr>
        
        <form action="index.html" onsubmit="alert('Pedido Realizado')">
            <input type="radio" id="pgto1" name="pgto" value="Pix">
            <label for="pgto1">🔷 Pix</label>
            <br>
            <input type="radio" id="pgto2" name="pgto" value="Cartão">
            <label for="pgto2">💳 Cartão</label>
            <br>
            <input type="submit" value="Finalizar Pedido">
        </form>

    </body>
</html>
