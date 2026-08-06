package database;

import java.sql.Connection;
import java.sql.SQLException;
import model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Agendamento;

public class AgendamentoDAO {
    private Connection conn;
    
    public AgendamentoDAO() throws SQLException, ClassNotFoundException{
        conn = Conexao.getConn();
    }
    
    public void novoAgendamento(Agendamento a) throws SQLException{
        String query = "INSERT INTO " +
        "agendamentos(id_usuario, data_agendamento, desc_agendamento) " +
        "VALUES(?, ?, ?);";
        
        PreparedStatement p = conn.prepareStatement(query);
        
        p.setInt(1, a.getUsuario().getIdUsuario());
        p.setDate(2, new java.sql.Date( a.getDataAgendamento().getTime() ) );
        p.setString(3, a.getDescAgendamento());
        
        p.execute();
        conn.close();
    }
    
    public ArrayList<Agendamento> selecionaPorUsuario(int idUsuario) throws SQLException {
        String query = "select * from agendamentos where id_usuario = " + idUsuario;
        
        PreparedStatement prep = conn.prepareStatement(query);
                
        ResultSet res = prep.executeQuery();
                
        ArrayList list = new ArrayList();
        
        while( res.next() ) {
            Agendamento a = new Agendamento();
            
            a.setIdAgendamento(res.getInt("id_agendamento"));
            a.setDataAgendamento(res.getDate("data_agendamento"));
            a.setDescAgendamento(res.getString("desc_agendamento"));
            
            list.add(a);
        }
        
        prep.close();
        return list;
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
     
    public void apagaAgendamento(int id) throws SQLException {
        String query = "delete from agendamentos "
                     + "where id_agendamento = " + id ;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.execute();
        prep.close();
    }
    
}
