/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AutorDAO;
import dao.CategoriaDAO;
import dao.ClassificacaoDAO;
import dao.EditoraDAO;
import dao.LivroDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Autor;
import modelo.Categoria;
import modelo.Classificacao;
import modelo.Editora;
import modelo.Livro;
import util.Upload;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "LivroCtl", urlPatterns = {"/admin/livro/LivroCtl"})
public class LivroCtl extends HttpServlet {

    private LivroDAO dao;
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
        List<Livro> lista;
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
        EditoraDAO editoraDAO = new EditoraDAO();
        AutorDAO autorDAO = new AutorDAO();

        List<Categoria> categoriaList = categoriaDAO.listar();
        List<Classificacao> classificacaoList = classificacaoDAO.listar();
        List<Editora> editoraList = editoraDAO.listar();
        List<Autor> autorList = autorDAO.listar();
        request.setAttribute("categoriaList", categoriaList);
        request.setAttribute("classificacaoList", classificacaoList);
        request.setAttribute("editoraList", editoraList);
        request.setAttribute("autorList", autorList);
        
        switch (acao) {
            case "del":
                String id = request.getParameter("id");
                dao = new LivroDAO();
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
                dao = new LivroDAO();
                Livro obj = dao.buscarPorChavePrimaria(Integer.parseInt(idu));
                request.setAttribute("obj", obj);

                pagina = "upd.jsp";
                
                break;

            case "list":
                dao = new LivroDAO();
                lista = dao.listar();
                // p onde deve ser redirecionada a página
                pagina = "index.jsp";                
                //passar a listagem para a pagina
                request.setAttribute("lista", lista);
                
                break;
            case "add":

                pagina = "add.jsp";
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
        Upload up = new Upload();
        //definir local de destino dos arquivos
        up.setFolderUpload("imagem");
        //Processar o formulário
        pagina = "add.jsp";
        if (up.formProcess(getServletContext(), request)) {
            if (up.getForm().get("txtNome") == null) {
                msg = "Campos obrigatórios não informados";
            } else {
                Livro obj = new Livro();
                dao = new LivroDAO();
                Boolean deucerto;
                //Testa se é alterar (com ID) ou cadastrar(sem ID)
                if (up.getForm().get("txtId") != null) {
                    //Se for alterar primeiro temos que buscar o objeto na
                    //base de dados, pois precisamos da imagem "original"
                    String meuid = up.getForm().get("txtId").toString();
                    obj = dao.buscarPorChavePrimaria(Integer.parseInt(meuid));

                    obj.setTitulo(up.getForm().get("txtNome").toString());
                    //gravo o nome do arquivo(se foi enviado um novo)
                    if (!up.getFiles().isEmpty()) {
                        obj.setImagem1(up.getFiles().get(0));
                        obj.setImagem2(up.getFiles().get(1));
                        obj.setImagem3(up.getFiles().get(2));

                    }
                    pagina = "upd.jsp";
                    deucerto = dao.alterar(obj);
                } else {
                    //atribuo os campos do formulário
                    obj.setTitulo(up.getForm().get("txtNome").toString());
                    //gravo o nome do arquivo
                    if (!up.getFiles().isEmpty()) {
                        obj.setImagem1(up.getFiles().get(0));
                        obj.setImagem2(up.getFiles().get(1));
                        obj.setImagem3(up.getFiles().get(2));

                    }
                    obj.setIsbn(up.getForm().get("txtISBN").toString());
                    obj.setSinopse(up.getForm().get("txtSinopse").toString());
                    obj.setIdioma(up.getForm().get("txtIdioma").toString());
                    obj.setEdicao(Short.parseShort(up.getForm().get("txtEdicao").toString()));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        obj.setDatapublicacao(sdf.parse(up.getForm().get("txtDataPublicacao").toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(LivroCtl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    obj.setPaginas(Short.parseShort(up.getForm().get("txtPaginas").toString()));
                    BigDecimal bd = new BigDecimal(up.getForm().get("txtPreco").toString());
                    obj.setPreco(bd);

                    String editoraid = up.getForm().get("selEditora").toString();
                    EditoraDAO editoraDAO = new EditoraDAO();
                    obj.setEditora(editoraDAO.buscarPorChavePrimaria(Integer.parseInt(editoraid)));

                    String categoriaid = up.getForm().get("selCategoria").toString();
                    CategoriaDAO categoriaDAO = new CategoriaDAO();
                    obj.setCategoria(categoriaDAO.buscarPorChavePrimaria(Integer.parseInt(categoriaid)));

                    String classificacaoid = up.getForm().get("selClassificacao").toString();
                    ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
                    obj.setClassificacao(classificacaoDAO.buscarPorChavePrimaria(Integer.parseInt(classificacaoid)));

                    String reqAutores = up.getForm().get("selAutores").toString();
                    String[] autores = reqAutores.split(";");
                    AutorDAO autorDAO = new AutorDAO();
                    List<Autor> listaAutores = new ArrayList();
                    for (String autore : autores) {
                        Autor a = autorDAO.buscarPorChavePrimaria(Integer.parseInt(autore));
                        listaAutores.add(a);
                    }
                    obj.setAutorList(listaAutores);

                    deucerto = dao.incluir(obj);
                }

                
                if (deucerto) {
                    msg = "Cadastro Ok";
                    pagina = "add.jsp";
                } else {
                    msg = "Cadastro com problema";
                }
            }
        } else {
            msg = "Não foi possível fazer o upload.";
        }
        request.setAttribute("msg", msg);
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
