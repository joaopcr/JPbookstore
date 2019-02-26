/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JP
 */
@Entity
@Table(name = "avaliacao")
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a")
    , @NamedQuery(name = "Avaliacao.findById", query = "SELECT a FROM Avaliacao a WHERE a.id = :id")
    , @NamedQuery(name = "Avaliacao.findByComentario", query = "SELECT a FROM Avaliacao a WHERE a.comentario = :comentario")
    , @NamedQuery(name = "Avaliacao.findByData", query = "SELECT a FROM Avaliacao a WHERE a.data = :data")
    , @NamedQuery(name = "Avaliacao.findByNota", query = "SELECT a FROM Avaliacao a WHERE a.nota = :nota")})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "nota")
    private Short nota;
    @JoinColumn(name = "livro", referencedColumnName = "id")
    @ManyToOne
    private Livro livro;
    @JoinColumn(name = "usuario", referencedColumnName = "email")
    @ManyToOne
    private Usuario usuario;

    public Avaliacao() {
    }

    public Avaliacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Short getNota() {
        return nota;
    }

    public void setNota(Short nota) {
        this.nota = nota;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Avaliacao[ id=" + id + " ]";
    }
    
}
