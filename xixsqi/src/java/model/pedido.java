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

    @Override
    public String toString() {
        return "pedido{" + "id=" + id + ", sabor=" + sabor + ", acomp=" + acomp + ", bebida=" + bebida + ", entrega=" + entrega + ", valor=" + valor + '}';
    }
    
    
}
