/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AutorDAO;
import dao.CarrinhoDAO;
import dao.CategoriaDAO;
import dao.ClassificacaoDAO;
import dao.EditoraDAO;
import dao.ItemvendaDAO;
import dao.LivroDAO;
import dao.UsuarioDAO;
import dao.VendaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Autor;
import modelo.Avaliacao;
import modelo.Carrinho;
import modelo.Categoria;
import modelo.Classificacao;
import modelo.Editora;
import modelo.Itemvenda;
import modelo.Livro;
import modelo.Usuario;
import modelo.Venda;

/**
 *
 * @author JP
 */
@WebServlet(name = "SiteCtl", urlPatterns = {"/gretong/SiteCtl"})
public class SiteCtl extends HttpServlet {

    private LivroDAO livroDAO;
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
    private AutorDAO autorDAO = new AutorDAO();
    private CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
    private EditoraDAO editoraDAO = new EditoraDAO();

    private Usuario usuario;

    private List<Livro> listaLivros;
    private List<Categoria> listaCategorias;
    private List<Classificacao> listaClassificacao;
    private List<Editora> listaEditoras;
    private List<Autor> listaAutores;

    private String pagina;
    private String caminho;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        pagina = request.getParameter("pagina");
        livroDAO = new LivroDAO();
        request.getSession().setMaxInactiveInterval(0);

        listaCategorias = categoriaDAO.listar();
        listaClassificacao = classificacaoDAO.listar();
        listaEditoras = editoraDAO.listar();
        listaAutores = autorDAO.listar();
        request.setAttribute("listaCategorias", listaCategorias);
        request.setAttribute("listaClassificacao", listaClassificacao);
        request.setAttribute("listaEditoras", listaEditoras);
        request.setAttribute("listaAutores", listaAutores);

        usuario = (Usuario) request.getSession().getAttribute("usuario");
        request.setAttribute("usuario", usuario);

        Carrinho carrinho;
        if (request.getSession().getAttribute("carrinho") != null) {
            carrinho = (Carrinho) request.getSession().getAttribute("carrinho");
        } else {
            carrinho = new Carrinho();
        }

        switch (pagina) {
            case "index":
                listaLivros = livroDAO.listar();
                request.setAttribute("listaLivros", this.listaLivros);
                caminho = "index.jsp";
                break;
            case "detalhes":
                String id = request.getParameter("id");
                Livro livro = livroDAO.buscarPorChavePrimaria(Integer.parseInt(id));
                List<Avaliacao> listaAvaliacao = livro.getAvaliacaoList();
                List<Venda> listaComprasUsuario;
                boolean podeComentar = false;
                if (request.getSession().getAttribute("usuario") != null) {
                    UsuarioDAO udao = new UsuarioDAO();
                    Usuario usu = (Usuario) request.getSession().getAttribute("usuario");
                    listaComprasUsuario = udao.buscarPorChavePrimaria(usu.getEmail()).getVendaList();

                    for (Venda venda : listaComprasUsuario) {
                        for (Itemvenda iv : venda.getItemvendaList()) {
                            if (iv.getLivro().getId() == Integer.parseInt(id)) {
                                podeComentar = true;
                            }
                        }
                    }

                    request.setAttribute("listaComprasUsuario", listaComprasUsuario);
                }
                request.setAttribute("podeComentar", podeComentar);
                request.setAttribute("livro", livro);
                request.setAttribute("listaAvaliacao", listaAvaliacao);
                caminho = "detalhes.jsp";
                break;
            case "lista":
                String filtroid = request.getParameter("id");
                String filtro = request.getParameter("filtro");

                if (filtro == null) {
                    listaLivros = livroDAO.listar();
                } else {
                    if (filtroid == null) {
                        String palavra = request.getParameter("pesquisa");
                        listaLivros = livroDAO.buscarPor(filtro, "%" + palavra + "%");
                    } else {
                        listaLivros = livroDAO.buscarPor(filtro, Integer.parseInt(filtroid));                        
                    }
                }

                request.setAttribute("listaLivros", listaLivros);
                request.setAttribute("quantidade", listaLivros.size());
                caminho = "lista.jsp";
                break;
            case "checkout":
                request.getSession().setAttribute("carrinho", carrinho);
                caminho = "checkout.jsp";
                break;
            case "venda":
                VendaDAO vendaDAO = new VendaDAO();
                Venda venda = new Venda();
                Itemvenda iv;
                ItemvendaDAO ivDAO = new ItemvendaDAO();

                venda.setData(new Date());
                venda.setTotal(new BigDecimal(carrinho.getTotal()));
                venda.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
                venda.setStatus('a');
                vendaDAO.incluir(venda);

                for (int i = 0; i < carrinho.getItemCarrinhoList().size(); i++) {
                    iv = new Itemvenda();
                    iv.setLivro(carrinho.getItemCarrinhoList().get(i).getLivro());
                    iv.setQuantidade(new Integer(carrinho.getItemCarrinhoList().get(i).getQuantidade()).shortValue());
                    iv.setValorunitario(carrinho.getItemCarrinhoList().get(i).getLivro().getPreco());
                    iv.setVenda(vendaDAO.buscarPorChavePrimaria(vendaDAO.listar().get(vendaDAO.listar().size() - 1).getId()));
                    ivDAO.incluir(iv);
                }

                /*for (Livro l : carrinho.getListaLivros()) {
                    iv = new Itemvenda();
                    iv.setLivro(l);
                    iv.setQuantidade(new Integer(1).shortValue());
                    iv.setValorunitario(l.getPreco());
                    iv.setVenda(vendaDAO.buscarPorChavePrimaria(vendaDAO.listar().get(vendaDAO.listar().size() - 1).getId()));
                    ivDAO.incluir(iv);
                }*/
                //carrinho.removerLivros();
                carrinho.limparCarrinho();
                request.getSession().setAttribute("carrinho", carrinho);
                caminho = "SiteCtl?pagina=perfil";

                break;

            case "perfil":
                if (request.getSession().getAttribute("usuario") != null) {
                    UsuarioDAO udao = new UsuarioDAO();
                    Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                    List<Venda> listaVendas = udao.buscarPorChavePrimaria(u.getEmail()).getVendaList();
                    request.setAttribute("listaVendas", listaVendas);

                    caminho = "perfil.jsp";
                } else {
                    caminho = "register.jsp";
                }
                break;
        }

        RequestDispatcher destino = request.getRequestDispatcher(caminho);
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
