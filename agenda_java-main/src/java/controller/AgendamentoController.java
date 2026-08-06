package controller;

import database.AgendamentoDAO;
import database.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Agendamento;
import model.Usuario;



@WebServlet(name = "AgendamentoController", urlPatterns = {"/AgendamentoController"})
public class AgendamentoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String flag = request.getParameter("flag");
        
        if (flag.equals("editar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String usuario = request.getParameter("usuario");
            String telefone = request.getParameter("telefone");
            String senha = request.getParameter("senha");
            
            Usuario user = new Usuario(id, usuario, telefone, senha);
            
            try {
                UsuarioDAO dao = new UsuarioDAO();
                dao.atualizaUsuario(user);
                request.getSession().setAttribute("userLogged", user);
                request.setAttribute("editar", true);
            } catch(ClassNotFoundException | SQLException e) {
                System.out.println(e);
                request.setAttribute("editar", false);
            }
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }
        
        if (flag.equals("excluir")) {
            int id = Integer.parseInt(request.getParameter("id"));
            
            try {
                AgendamentoDAO dao = new AgendamentoDAO();
                dao.apagaAgendamento(id);
                request.setAttribute("excluir", true);
            } catch(ClassNotFoundException | SQLException e) {
                System.out.println(e);
                request.setAttribute("excluir", false);
            }
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }
                
        if( flag.equals("salvar") ) {
            Usuario usuario = (Usuario)request.getSession().getAttribute("userLogged");
            String dataAgenda = request.getParameter("data-agenda");
            String desc = request.getParameter("desc");
            
            SimpleDateFormat convert = new SimpleDateFormat("yyyy-MM-dd ddHH:mm:ss");
            
            try {
                Agendamento a = new Agendamento();
                a.setUsuario(usuario);
                a.setDataAgendamento( convert.parse(dataAgenda) );
                a.setDescAgendamento(desc);
            
                AgendamentoDAO dao = new AgendamentoDAO();
                dao.novoAgendamento(a);
                request.setAttribute("flag", "ok");
            } catch(ParseException | ClassNotFoundException | SQLException e) {
                System.err.println(e);
                request.setAttribute("flag", "erro");
            }
            
            request.getRequestDispatcher("inicio.jsp")
                    .forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
