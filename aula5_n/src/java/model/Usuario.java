package model;

import java.util.Date;

public class Usuario {
    //Atributos
    
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Date dataNasc;
    private String senha;
    private boolean avisos;
    
    //metodo construtor
    public Usuario(
    int id,
    String nome,
    String cpf,
    String email,
    String telefone,
    Date dataNasc,
    String senha,
    boolean avisos
    ){
      this.id = id;  
      this.nome = nome;  
      this.cpf = cpf;  
      this.email = email;  
      this.telefone = telefone;  
      this.dataNasc = dataNasc;  
      this.senha = senha;  
      this.avisos = avisos;  
    }
    
    //Construtor vazio
    
    public Usuario(){}
    
    //Getters
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public Date getDataNasc(){
        return this.dataNasc;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAvisos() {
        return avisos;
    }
    
    //Setters
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAvisos(boolean avisos) {
        this.avisos = avisos;
    }
    
    //Método toString

    @Override
    public String toString() {
        return "<hr>id=" + id +
                "<br> nome=" + nome +
                "<br> cpf=" + cpf +
                "<br> email=" + email +
                "<br> telefone=" + telefone +
                "<br> dataNasc=" + dataNasc +
                "<br> senha=" + senha +
                "<br> avisos=" + avisos + '}';
    }
    
}
