package database;

import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
    private Connection conn;
    
    public UsuarioDAO() throws SQLException, ClassNotFoundException{
        conn = Conexao.getConn();
    }
    
    public void novoUsuario(Usuario u) throws SQLException{
        String query = "INSERT INTO " +
        "usuarios(nome_usuario, telefone_usuario, senha_usuario) " +
        "VALUES(?, ?, ?);";
        
        PreparedStatement p = conn.prepareStatement(query);
        
        p.setString(1, u.getNomeUsuario());
        p.setString(2, u.getTelefoneUsuario());
        p.setString(3, u.getSenhaUsuario());
        
        p.execute();
        conn.close();
    }
    
    public Usuario selecionaPorNome(String nome) throws SQLException {
        String query = "select * from usuarios where nome_usuario = ?";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, nome);
        
        ResultSet res = prep.executeQuery();
        
        Usuario u = new Usuario();
        
        if( res.next() ) {
            u.setIdUsuario(res.getInt("id_usuario"));
            u.setNomeUsuario(res.getString("nome_usuario"));
            u.setTelefoneUsuario(res.getString("telefone_usuario"));
            u.setSenhaUsuario(res.getString("senha_usuario"));
        }
        
        prep.close();
        return u;
    }
    
    public Usuario selecionaPorId(int id) throws SQLException {
        String query = "select * from usuarios where id_usuario = ?";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setInt(1, id);
        
        ResultSet res = prep.executeQuery();
        
        Usuario u = new Usuario();
        
        if( res.next() ) {
            u.setIdUsuario(res.getInt("id_usuario"));
            u.setNomeUsuario(res.getString("nome_usuario"));
            u.setTelefoneUsuario(res.getString("telefone_usuario"));
            u.setSenhaUsuario(res.getString("senha_usuario"));
        }
        
        prep.close();
        return u;
    }
    
     public ArrayList<Usuario> selecionaTodos() throws SQLException {
        
        ArrayList<Usuario> list = new ArrayList();
        
        String query = "select * from usuarios;";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        ResultSet res = prep.executeQuery();
        
        while( res.next() ) {
            Usuario user = new Usuario();
            
            user.setIdUsuario(res.getInt("id_usuario") );
            user.setNomeUsuario(res.getString("nome_usuario") );
            user.setTelefoneUsuario(res.getString("telefone_usuario") );
            user.setSenhaUsuario(res.getString("senha_usuario") );
            
            list.add(user);
            System.out.println(user);
        }
        
        prep.close();
        return list;
    }
     
     
     public void atualizaUsuario(Usuario user) throws SQLException {
        String query = "update usuarios set nome_usuario = ?, "
                     + "telefone_usuario = ?, senha_usuario = ? "
                     + "where id_usuario = ?";
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.setString(1, user.getNomeUsuario());
        prep.setString(2, user.getTelefoneUsuario());
        prep.setString(3, user.getSenhaUsuario());
        prep.setInt(4, user.getIdUsuario());
        
        prep.execute();
        prep.close();
    }
     
    public void apagaUsuario(int id) throws SQLException {
        String query = "delete from usuarios "
                     + "where id = " + id ;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.execute();
        prep.close();
    }
    
}
