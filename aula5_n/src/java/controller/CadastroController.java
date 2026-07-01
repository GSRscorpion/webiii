package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;


@WebServlet(name = "CadastroController", urlPatterns = {"/CadastroController"})
public class CadastroController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        //inportaando classe para
        SimpleDateFormat dataTexto = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dataBR = new SimpleDateFormat("dd/MM/yyyy");
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String dataNasc = request.getParameter("data-nasc");
        String senha = request.getParameter("senha");
        boolean avisos = request.getParameter("avisos")!=null;
        
        //criando objeto da classe usuário
        Usuario user01 = new Usuario();
        user01.setId(1);
        user01.setNome(nome);
        user01.setCpf(cpf);
        user01.setTelefone(telefone);
        user01.setEmail(email);
        user01.setDataNasc(dataTexto.parse(dataNasc));
        user01.setSenha(senha);
        user01.setAvisos(avisos);
        
        //utilizando o construtor com dados
        Usuario user02 = new Usuario(
                0,
                nome,
                cpf,
                email,
                telefone,
                dataTexto.parse(dataNasc),
                senha,
                avisos
        );
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h4>"+ nome + "</h4>");
            out.println("<h4>"+ cpf + "</h4>");
            out.println("<h4>"+ telefone + "</h4>");
            out.println("<h4>"+ email + "</h4>");
            out.println("<h4>"+ dataNasc + "</h4>");
            out.println("<h4>"+ senha + "</h4>");
            out.println("<h4>"+ avisos + "</h4>");
            out.println("<h4>"+ user01.getNome()+ "</h4>");
            out.println("<h4>"+ dataBR.format(user01.getDataNasc()) + "</h4>");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            System.getLogger(CadastroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            System.getLogger(CadastroController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
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
