/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JP
 */
@Entity
@Table(name = "livro")
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")
    , @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id")
    , @NamedQuery(name = "Livro.findByDatapublicacao", query = "SELECT l FROM Livro l WHERE l.datapublicacao = :datapublicacao")
    , @NamedQuery(name = "Livro.findByEdicao", query = "SELECT l FROM Livro l WHERE l.edicao = :edicao")
    , @NamedQuery(name = "Livro.findByIdioma", query = "SELECT l FROM Livro l WHERE l.idioma = :idioma")
    , @NamedQuery(name = "Livro.findByImagem1", query = "SELECT l FROM Livro l WHERE l.imagem1 = :imagem1")
    , @NamedQuery(name = "Livro.findByImagem2", query = "SELECT l FROM Livro l WHERE l.imagem2 = :imagem2")
    , @NamedQuery(name = "Livro.findByImagem3", query = "SELECT l FROM Livro l WHERE l.imagem3 = :imagem3")
    , @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Livro.findByPaginas", query = "SELECT l FROM Livro l WHERE l.paginas = :paginas")
    , @NamedQuery(name = "Livro.findByPreco", query = "SELECT l FROM Livro l WHERE l.preco = :preco")
    , @NamedQuery(name = "Livro.findBySinopse", query = "SELECT l FROM Livro l WHERE l.sinopse = :sinopse")
    , @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Livro.categoria", query = "SELECT l FROM Livro l WHERE l.categoria.id = :categoria")
    , @NamedQuery(name = "Livro.classificacao", query = "SELECT l FROM Livro l WHERE l.classificacao.id = :classificacao")
    , @NamedQuery(name = "Livro.editora", query = "SELECT l FROM Livro l WHERE l.editora.id = :editora")
    , @NamedQuery(name = "Livro.pesquisar", query = "SELECT l FROM Livro l WHERE lower(l.titulo) LIKE lower(:pesquisar)")    
})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datapublicacao")
    @Temporal(TemporalType.DATE)
    private Date datapublicacao;
    @Column(name = "edicao")
    private Short edicao;
    @Column(name = "idioma")
    private String idioma;
    @Column(name = "imagem1")
    private String imagem1;
    @Column(name = "imagem2")
    private String imagem2;
    @Column(name = "imagem3")
    private String imagem3;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "paginas")
    private Short paginas;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "sinopse")
    private String sinopse;
    @Column(name = "titulo")
    private String titulo;
    @JoinTable(name = "autorlivro", joinColumns = {
        @JoinColumn(name = "livro", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "autor", referencedColumnName = "id")})
    private List<Autor> autorList;
    @OneToMany(mappedBy = "livro")
    private List<Itemvenda> itemvendaList;
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @ManyToOne
    private Categoria categoria;
    @JoinColumn(name = "classificacao", referencedColumnName = "id")
    @ManyToOne
    private Classificacao classificacao;
    @JoinColumn(name = "editora", referencedColumnName = "id")
    @ManyToOne
    private Editora editora;
    @OneToMany(mappedBy = "livro")
    private List<Avaliacao> avaliacaoList;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatapublicacao() {
        return datapublicacao;
    }

    public void setDatapublicacao(Date datapublicacao) {
        this.datapublicacao = datapublicacao;
    }

    public Short getEdicao() {
        return edicao;
    }

    public void setEdicao(Short edicao) {
        this.edicao = edicao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Short getPaginas() {
        return paginas;
    }

    public void setPaginas(Short paginas) {
        this.paginas = paginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public List<Itemvenda> getItemvendaList() {
        return itemvendaList;
    }

    public void setItemvendaList(List<Itemvenda> itemvendaList) {
        this.itemvendaList = itemvendaList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public void setAvaliacaoList(List<Avaliacao> avaliacaoList) {
        this.avaliacaoList = avaliacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Livro[ id=" + id + " ]";
    }

}
