/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ClassificacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Classificacao;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ClassificacaoCtl", urlPatterns = {"/admin/classificacao/ClassificacaoCtl"})
public class ClassificacaoCtl extends HttpServlet {

    private ClassificacaoDAO dao;
    private String pagina;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //indica a ação que será executada via get
        String acao;
        acao = request.getParameter("acao");
        dao = new ClassificacaoDAO();
        List<Classificacao> lista;
        switch (acao) {
            case "del":
                String id = request.getParameter("id");
                pagina = "index.jsp";
                boolean deucerto = dao.excluir(Integer.parseInt(id));
                if (deucerto) {
                    lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.setAttribute("msg", "Excluído com sucesso");
                } else {
                    request.setAttribute("msg", "ERRO");
                }
                
                break;
            case "upd":
                String idu = request.getParameter("id");
                pagina = "index.jsp";
                Classificacao obj = dao.buscarPorChavePrimaria(Integer.parseInt(idu));
                request.setAttribute("obj", obj);
                pagina = "upd.jsp";
                
                break;
            case "list":
                lista = dao.listar();
                //pra onde dever ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                
                break;
            default:
                
                pagina = "index.jsp";
        }
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg;
        if (request.getParameter("txtNome") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new ClassificacaoDAO();
            Classificacao obj = new Classificacao();

            Boolean deucerto;
            String pagina;
            if (request.getParameter("txtId") != null) {
                obj = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("txtId")));
                obj.setNome(request.getParameter("txtNome"));
                deucerto = dao.alterar(obj);
                pagina = "upd.jsp";
            } else {
                obj = new Classificacao();
                obj.setNome(request.getParameter("txtNome"));
                deucerto = dao.incluir(obj);

                pagina = "add.jsp";
            }
            if (deucerto) {
                msg = "Registro cadastrado com sucesso";
            } else {
                msg = "Erro ao cadastrar";
            }
            
            request.setAttribute("msg", msg);
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
