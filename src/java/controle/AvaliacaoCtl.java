/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AvaliacaoDAO;
import dao.LivroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Avaliacao;
import modelo.Livro;
import modelo.Usuario;

/**
 *
 * @author JP
 */
@WebServlet(name = "AvaliacaoCtl", urlPatterns = {"/gretong/AvaliacaoCtl"})
public class AvaliacaoCtl extends HttpServlet {
    
    private AvaliacaoDAO avaliacaoDAO;
    private String pagina;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        avaliacaoDAO = new AvaliacaoDAO();
        LivroDAO livroDAO = new LivroDAO();
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");        
        Livro livro = livroDAO.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id")));
        
        String comentario = request.getParameter("comentario");
        String nota = request.getParameter("nota");
        
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setComentario(comentario);
        avaliacao.setData(new Date());
        avaliacao.setLivro(livro);
        avaliacao.setUsuario(usuario);
        avaliacao.setNota(Short.parseShort(nota));
        
        avaliacaoDAO.incluir(avaliacao);
        response.sendRedirect("SiteCtl?pagina=detalhes&id=" + request.getParameter("id"));
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
