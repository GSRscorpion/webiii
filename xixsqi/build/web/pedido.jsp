<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XIS QI - pedido</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <h1>Novo pedido</h1>
        <h2>Escolha os items do seu pedido</h2>
        
        <form action="pedidoController" method="get">
            <h3> 🍔 Sabor</h3>
            <input type="radio" id="sabor1" name="sabor" value="Xis Carme">
            <label for="sabor1"> Xis Carne </label>
            <br>
            
            <input type="radio" id="sabor2" name="sabor" value="Xis Frango">
            <label for="sabor2"> Xis Salada </label>
            <br>
            
            <input type="radio" id="sabor3" name="sabor" value="Xis Calabresa">
            <label for="sabor3"> Xis Calabresa </label>
            <br>
            
            <input type="radio" id="sabor4" name="sabor" value="Xis Bacon">
            <label for="sabor4"> Xis Bacon </label>
            <br>
            
            <input type="radio" id="sabor5" name="sabor" value="Xis Coráção">
            <label for="sabor5"> Xis Coráção </label>
            <br>
            
            <hr>
            
            <h3> 🍟 Acompanhamentos</h3>
            <input type="checkbox" id="acomp1" name="acomp[]" value="Batata frita">
            <label for="acomp1"> Batata frita </label>
            <br>
            
            <input type="checkbox" id="acomp2" name="acomp[]" value="Anéis de cebola">
            <label for="acomp2"> Anéis de cebola </label>
            <br>
            
            <input type="checkbox" id="acomp3" name="acomp[]" value="Batata /c cheddar e bacon">
            <label for="acomp3"> Batata /c cheddar e bacon </label>
            <br>
            
            <input type="checkbox" id="acomp4" name="acomp[]" value="Maionese caseira">
            <label for="acomp4"> Maionese caseira </label>
            <br>
            
            
            <hr>
            
            <h3> 🥤  Bebidas</h3>
            <input type="radio" id="bebida1" name="bebida" value="fruki Guarana 2L">
            <label for="bebida1"> fruki Guarana 2L </label>
            <br>
            
            <input type="radio" id="bebida2" name="bebida" value="Coca-cola 2L">
            <label for="2"> Coca-cola 2L </label>
            <br>
            
            <input type="radio" id="bebida3" name="bebida" value="Cerveja brahma 1L">
            <label for="bebida3"> Cerveja brahma 1L </label>
            <br>
            
            <input type="radio" id="bebida3" name="bebida" value="Energético baly 2L">
            <label for="bebida3"> Energético baly 2L</label>
            <br>
            <hr>
            
            <h3> 🛵 Entrega</h3>
            <input type="radio" id="entrega1" name="entrega" value="Retirada da loja">
            <label for="Entrega1">Retirada da loja</label>
            <br>
            
            <input type="radio" id="entrega2" name="entrega" value="Delivery">
            <label for="Entrega1">Delivery</label>
            <br>
            
              
            <hr>
            <input type="submit"  value="Continuar pedido">
        </form>
    </body>
</html>
