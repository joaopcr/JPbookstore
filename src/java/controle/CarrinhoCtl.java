/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CarrinhoDAO;
import dao.LivroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JP
 */
@WebServlet(name = "CarrinhoCtl", urlPatterns = {"/gretong/CarrinhoCtl"})
public class CarrinhoCtl extends HttpServlet {

    private CarrinhoDAO dao = new CarrinhoDAO();

    private LivroDAO livroDAO = new LivroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        switch (acao) {
            case "get":
                request.getSession().setAttribute("carrinho", dao.getCarrinho());
                break;
            case "del":
                dao.removerLivro(livroDAO.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id"))));
                break;
        }
        request.getSession().setAttribute("carrinho", dao.getCarrinho());
        RequestDispatcher destino = request.getRequestDispatcher("SiteCtl?pagina=checkout");
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao.adicionarLivro(livroDAO.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id"))));
        request.getSession().setAttribute("carrinho", dao.getCarrinho());
        
        response.sendRedirect("SiteCtl?pagina=checkout");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
