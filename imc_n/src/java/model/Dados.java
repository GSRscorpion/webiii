package model;


public class Dados {
    private double peso;
    private double altura;
    
    public Dados(){}

    public Dados(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }
    
    public double calcular(){
        return this.peso / Math.pow(altura, 2);
    }
    
    public String emitirLaudo(){
        String laudo = "";
        double imc = calcular();
        
        if(imc < 18.5){
            laudo = "Magreza (abaixo do peso)";
        }else if(imc >= 18.5 && imc < 25){
            laudo = "Saudavel (peso ideal)";
        } else {
            laudo = "Sobrepeso";
        }
        
        
        
        return laudo;
    }
    
    @Override
    public String toString(){
        return "<hr>" + "<h3>Resultado</h3> " + "<ul> "
                + "<li>PESO:" + this.peso +   " kg</li>  "
                + "<li>ALTURA:" + this.altura +   " m </li> "
                + "<li>IMC:" + calcular() +   " kg/m² </li> "
                + "<li>" + emitirLaudo() + "</li> " 
                + "</ul>";
    }
}
