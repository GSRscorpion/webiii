package model;

import database.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String telefoneUsuario;
    private String senhaUsuario;
    
    
    public Usuario(){}

    public Usuario(String nomeUsuario, String senhaUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario(int idUsuario, String nomeUsuario, String telefoneUsuario, String senhaUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public boolean login(String nome, String senha) throws ClassNotFoundException, SQLException {
        boolean key = false;
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.selecionaPorNome(nome);
        
        if( senha.equals(user.senhaUsuario) ) {
            key = true;
        }
               
        return key;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", telefoneUsuario=" + telefoneUsuario + ", senhaUsuario=" + senhaUsuario + '}';
    }
    
    
}
