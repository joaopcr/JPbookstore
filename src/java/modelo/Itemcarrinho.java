/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JP
 */
public class Itemcarrinho {

    private Carrinho carrinho;
    private Livro livro;
    private int quantidade;

    public Itemcarrinho(Carrinho _carrinho, Livro _livro) {
        this.carrinho = _carrinho;
        this.livro = _livro;
        this.quantidade = 1;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }        

}
