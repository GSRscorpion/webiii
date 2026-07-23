package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    private Connection conn;
    
    public UsuarioDAO() throws ClassNotFoundException, SQLException{
        conn = Conexao.getConn();
    }
    
    public void novoUsuario(Usuario u) throws SQLException{
        String query = "INSERT INTO Usuarios(nome_usuario, telefone_usuario, senha_usuario) " +
                "VALUES(?, ?, ?);";
        
        PreparedStatement p = conn.prepareStatement(query);
        
        p.setString(1, u.getNomeUsuario());
        p.setString(2, u.getTelefoneUsuario());
        p.setString(3, u.getSenhaUsuario());
        
        p.execute();
        conn.close();
    }
}
