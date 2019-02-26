/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.Id;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Gabriele
 */
@WebServlet(name = "UsuarioCtl", urlPatterns = {"/admin/usuario/UsuarioCtl"})
public class UsuarioCtl extends HttpServlet {

    private UsuarioDAO dao;

    private String pagina;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao;
        acao = request.getParameter("acao");
        List<Usuario> lista;
        boolean ir = true;
        switch (acao) {
            case "sair":
                request.getSession().setAttribute("usuario", null);
                response.sendRedirect("../../gretong/SiteCtl?pagina=index");
                ir = false;
                break;
            case "del":
                String id = request.getParameter("id");
                pagina = "index.jsp";
                boolean deucerto = dao.excluir(id);
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
                Usuario obj = dao.buscarPorChavePrimaria(idu);
                request.setAttribute("obj", obj);
                pagina = "upd.jsp";
                
                break;
            case "list":

                dao = new UsuarioDAO();
                lista = dao.listar();
                // p onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a pagina
                request.setAttribute("lista", lista);
                break;
            default:
                pagina = "index.jsp";
        }
        if (ir) {
            RequestDispatcher destino;
            destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
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
        String msg = "Ola";

        dao = new UsuarioDAO();
        String action = request.getParameter("action");
        Boolean deucerto = null;
        boolean ir = true;
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");
        String cep = request.getParameter("cep");
        String endereco = request.getParameter("endereco");
        String cpf = request.getParameter("cpf");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String fone = request.getParameter("fone");
        String op = request.getParameter("op");
        boolean isAdmin = false;
        if (op.equals("login")) {
            String destino = "";
            email = request.getParameter("email");
            senha = request.getParameter("senha");
            List<Usuario> listaUsuariosLogin = dao.buscarLogin(email, senha);
            if(listaUsuariosLogin.isEmpty()){
                response.sendRedirect("../../gretong/SiteCtl?pagina=index");
                return;
            }
            if (listaUsuariosLogin.size() > 0) {
                Usuario usuario = listaUsuariosLogin.get(0);
                request.getSession().setAttribute("usuario", usuario);
                ir = false;
            } 
            if (email.equals("admin") && senha.equals("admin")) {
                isAdmin = true;
                destino = "../inicial/index.jsp";
            } else {
                isAdmin = false;
                destino = "../../gretong/SiteCtl?pagina=index";
            }
            request.getSession().setAttribute("isAdmin", isAdmin);
            response.sendRedirect(destino);
        }
        if (op.equals("registrar")) {
            Usuario obj;
            obj = new Usuario();
            obj.setEmail(email);
            obj.setNome(nome);
            obj.setCep(cep);
            obj.setCidade(cidade);
            obj.setCpf(cpf);
            obj.setEndereco(endereco);
            obj.setFone(fone);
            obj.setSenha(senha);
            obj.setUf(uf);
            deucerto = dao.incluir(obj);
            if (deucerto) {
                msg = "Registro cadastrado com sucesso";
            } else {
                msg = "Erro ao cadastrar";
            }
            response.sendRedirect("SiteCtl?pagina=index");

        }
        if (op.equals("add")) {
            Usuario obj;
            obj = new Usuario();
            obj.setEmail(email);
            obj.setNome(nome);
            obj.setCep(cep);
            obj.setCidade(cidade);
            obj.setCpf(cpf);
            obj.setEndereco(endereco);
            obj.setFone(fone);
            obj.setSenha(senha);
            obj.setUf(uf);
            deucerto = dao.incluir(obj);
            if (deucerto) {
                msg = "Registro cadastrado com sucesso";
            } else {
                msg = "Erro ao cadastrar";
            }
            pagina = "add.jsp";

        }
        if (op.equals("upd")) {
            Usuario obj = dao.buscarPorChavePrimaria(email);
            obj.setNome(nome);
            obj.setCep(cep);
            obj.setCidade(cidade);
            obj.setCpf(cpf);
            obj.setEndereco(endereco);
            obj.setFone(fone);
            obj.setSenha(senha);
            obj.setUf(uf);
            deucerto = dao.alterar(obj);
            if (deucerto) {
                msg = "Registro cadastrado com sucesso";
            } else {
                msg = "Erro ao cadastrar";
            }
            pagina = "upd.jsp";
        }
        if (ir) {
            request.setAttribute("msg", msg);
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
