package controle;

import dao.CategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Categoria;

@WebServlet(name = "CategoriaCtl", urlPatterns = {"/admin/categoria/CategoriaCtl"})
public class CategoriaCtl extends HttpServlet {

    private CategoriaDAO dao;
    private String pagina;

    private void IrPara(HttpServletRequest request, HttpServletResponse response, String pagina) throws ServletException, IOException {
        
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        dao = new CategoriaDAO();

        switch (acao) {
            case "del":
                Delete(request, response);
                break;
            case "upd":                
                Categoria obj = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("obj", obj);
                pagina = "upd.jsp";                
                break;
            case "list":
                List(request, response);
                break;
            default:

                pagina = "index.jsp";
        }

        IrPara(request, response, pagina);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String msg = "";
        String classe = "";

        dao = new CategoriaDAO();

        if (request.getParameter("txtId") != null) {
            Update(request, response, msg, classe);
        } else {
            Create(request, response, msg, classe);
        }

        request.setAttribute("msg", msg);
        request.setAttribute("classe", classe);
        IrPara(request, response, pagina);
    }

    private void Create(HttpServletRequest request, HttpServletResponse response, String msg, String classe) {

        String nome = request.getParameter("txtNome");

        Categoria obj = new Categoria();
        obj.setNome(nome);

        if (dao.incluir(obj)) {
            msg = "Deu certo!";
            classe = "success";
        } else {
            msg = "Não foi possível realizar o cadastro!";
            classe = "danger";
        }
        pagina = "add.jsp";
    }

    private void List(HttpServletRequest request, HttpServletResponse response) {
        
        List<Categoria> lista;
        
        if (request.getParameter("filtro") != null) {
            String filtro = request.getParameter("filtro");
            lista = dao.listar(filtro);
        } else {
            lista = dao.listar();
        }
        pagina = "index.jsp";        
        request.setAttribute("lista", lista);        
    }

    private void Update(HttpServletRequest request, HttpServletResponse response, String msg, String classe) {

        String nome = request.getParameter("txtNome");

        Categoria obj = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("txtId")));
        obj.setNome(nome);

        if (dao.alterar(obj)) {
            msg = "Deu certo!";
            classe = "success";
        } else {
            msg = "Não foi possível realizar o cadastro!";
            classe = "danger";
        }
        pagina = "upd.jsp";        
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");

        pagina = "index.jsp";

        if (dao.excluir(Integer.parseInt(id))) {
            List(request, response);
            request.setAttribute("msg", "Excluído com sucesso");
        } else {
            request.setAttribute("msg", "ERRO");
        }        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
