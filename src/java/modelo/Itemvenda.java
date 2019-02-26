/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

/**
 *
 * @author JP
 */
@Entity
@Table(name = "itemvenda")
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i")
    , @NamedQuery(name = "Itemvenda.findById", query = "SELECT i FROM Itemvenda i WHERE i.id = :id")
    , @NamedQuery(name = "Itemvenda.findByQuantidade", query = "SELECT i FROM Itemvenda i WHERE i.quantidade = :quantidade")
    , @NamedQuery(name = "Itemvenda.findByValorunitario", query = "SELECT i FROM Itemvenda i WHERE i.valorunitario = :valorunitario")})
public class Itemvenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantidade")
    private Short quantidade;
    @Column(name = "valorunitario")
    private BigDecimal valorunitario;
    @JoinColumn(name = "livro", referencedColumnName = "id")
    @ManyToOne
    private Livro livro;
    @JoinColumn(name = "venda", referencedColumnName = "id")
    @ManyToOne
    private Venda venda;

    public Itemvenda() {
    }

    public Itemvenda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Short quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
        if (!(object instanceof Itemvenda)) {
            return false;
        }
        Itemvenda other = (Itemvenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Itemvenda[ id=" + id + " ]";
    }
    
}
