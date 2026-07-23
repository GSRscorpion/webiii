package model;

import java.util.Date;


public class Agendamento {
   private int idAgendamento;
   private Usuario usuario;
   private Date dataAgendamento;
   private String descAgendamento;
   
   public Agendamento(){}

    public Agendamento(int idAgendamento, Usuario usuario, Date dataAgendamento, String descAgendamento) {
        this.idAgendamento = idAgendamento;
        this.usuario = usuario;
        this.dataAgendamento = dataAgendamento;
        this.descAgendamento = descAgendamento;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDescAgendamento() {
        return descAgendamento;
    }

    public void setDescAgendamento(String descAgendamento) {
        this.descAgendamento = descAgendamento;
    }

    @Override
    public String toString() {
        return "Agendamento{" + "idAgendamento=" + idAgendamento + ", usuario=" + usuario + ", dataAgendamento=" + dataAgendamento + ", descAgendamento=" + descAgendamento + '}';
    }
   
   
}
