/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.EditoraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Editora;
import util.Upload;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "EditoraCtl", urlPatterns = {"/admin/editora/EditoraCtl"})
public class EditoraCtl extends HttpServlet {

    private EditoraDAO dao;
    private String pagina;

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
        String acao;
        acao = request.getParameter("acao");
        List<Editora> lista;
        switch (acao) {
            case "del":
                String id = request.getParameter("id");
                dao = new EditoraDAO();
                Boolean deucerto = dao.excluir(Integer.parseInt(id));
                pagina = "index.jsp";

                lista = dao.listar();
                request.setAttribute("lista", lista);
                if (deucerto) {

                    request.setAttribute("msg", "Exclusão OK");
                } else {
                    request.setAttribute("msg", "Erro ao excluir");
                }
                
                break;

            case "upd":
                String idu = request.getParameter("id");
                dao = new EditoraDAO();
                Editora obj = dao.buscarPorChavePrimaria(Integer.parseInt(idu));
                request.setAttribute("obj", obj);
                pagina = "upd.jsp";
                
                break;

            case "list":
                dao = new EditoraDAO();
                lista = dao.listar();
                // p onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a pagina
                request.setAttribute("lista", lista);
                
                break;
            default:
                pagina = "index.jsp";
        }
        RequestDispatcher destino;
        destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
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
        String msg;
        String classe = "";
        Upload up = new Upload();
        //definir local de destino dos arquivos
        up.setFolderUpload("imagem");
        //Processar o formulário
        pagina = "add.jsp";
        if (up.formProcess(getServletContext(), request)) {
            if (up.getForm().get("txtNome") == null) {
                msg = "Campos obrigatórios não informados";
            } else {
                Editora obj = new Editora();
                dao = new EditoraDAO();
                Boolean deucerto;
                //Testa se é alterar (com ID) ou cadastrar(sem ID)
                if (up.getForm().get("txtId") != null) {
                    //Se for alterar primeiro temos que buscar o objeto na
                    //base de dados, pois precisamos da imagem "original"
                    String meuid = up.getForm().get("txtId").toString();
                    obj = dao.buscarPorChavePrimaria(Integer.parseInt(meuid));

                    obj.setNome(up.getForm().get("txtNome").toString());
                    //gravo o nome do arquivo(se foi enviado um novo)
                    if (!up.getFiles().isEmpty()) {
                        obj.setLogo(up.getFiles().get(0));

                    }
                    pagina = "upd.jsp";
                    deucerto = dao.alterar(obj);
                } else {
                    //atribuo os campos do formulário
                    obj.setNome(up.getForm().get("txtNome").toString());
                    //gravo o nome do arquivo
                    if (!up.getFiles().isEmpty()) {
                        obj.setLogo(up.getFiles().get(0));

                    }
                    deucerto = dao.incluir(obj);
                }
                
                
                if (deucerto) {
                    msg = "Cadastro Ok";
                    classe = "alert-success";
                } else {
                    msg = "Cadastro com problema";
                }
            }
        } else {
            msg = "Não foi possível fazer o upload.";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("classe", classe);
        RequestDispatcher destino;
        destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
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
