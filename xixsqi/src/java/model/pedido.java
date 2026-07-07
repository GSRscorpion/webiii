package model;


public class pedido {
    private int id;
    private String sabor;
    private String acomp[];
    private String bebida;
    private String entrega;
    private double valor;

    public pedido() {
        
        
}

    public pedido(String sabor, String[] acomp, String bebida, String entrega) {
        this.sabor = sabor;
        this.acomp = acomp;
        this.bebida = bebida;
        this.entrega = entrega;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String[] getAcomp() {
        return acomp;
    }

    public void setAcomp(String[] acomp) {
        this.acomp = acomp;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getTodosAcomp(){
        if(this.acomp != null){
        String acomps = "";
        for( int i=0; i < this.acomp.length; i++ ){
            acomps += this.acomp[i] + "/";
          }
          return acomps;
        }
        return "Nenhum acompanhamento";
     }
    
    public void calcularPedido(){
        double subTotal = 0.00;
        
        switch( this.sabor ) {
            case "Xis Carne": subTotal += 20.00;
            break;
            case "Xis Frango": subTotal += 18.00;
            break;
            case "Xis Calabresa": subTotal += 24.00;
            break;
            case "Xis Bacon": subTotal += 23.00;
            break;
            case "Xis Coráção": subTotal += 25.00;
            break;
        }
        
        if(this.acomp != null){
            subTotal += this.acomp.length * 5;
        }
        
        switch( this.bebida ) {
            case "fruki Guarana 2L": subTotal += 7.00;
            break;
            case "Coca-cola 2L": subTotal += 12.00;
            break;
            case "Cerveja brahma 1L": subTotal += 10.00;
            break;
            case "Energético baly 2L": subTotal += 14.00;
            break;
        }
        if( this.entrega.equals("Delivery") ){
            subTotal += 15.00;
        }
        this.valor = subTotal;
    }
    

    @Override
    public String toString() {
        return "pedido{" + "id=" + id + ", sabor=" + sabor + ", acomp=" + getTodosAcomp() + ", bebida=" + bebida + ", entrega=" + entrega + ", valor=" + valor + '}';
    }
    
    
}
