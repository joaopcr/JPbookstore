/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Carrinho;
import modelo.Itemcarrinho;
import modelo.Livro;

/**
 *
 * @author JP
 */
public class CarrinhoDAO {

    private Carrinho carrinho;

    public CarrinhoDAO() {
        this.carrinho = new Carrinho();
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void adicionarLivro(Livro livro) {
        boolean achou = false;
        for (int i = 0; i < this.carrinho.getItemCarrinhoList().size(); i++) {
            if (this.carrinho.getItemCarrinhoList().get(i).getLivro() == livro) {
                this.carrinho.getItemCarrinhoList().get(i).setQuantidade(this.carrinho.getItemCarrinhoList().get(i).getQuantidade() + 1);
                achou = true;
            }
        }

        if (!achou) {
            this.carrinho.getItemCarrinhoList().add(new Itemcarrinho(this.carrinho, livro));
        }

        carrinho.calcularValorTotal();
    }

    public void removerLivro(Livro livro) {
        for (int i = 0; i < this.carrinho.getItemCarrinhoList().size(); i++) {
            if (this.carrinho.getItemCarrinhoList().get(i).getLivro() == livro) {
                if (this.carrinho.getItemCarrinhoList().get(i).getQuantidade() > 1) {
                    this.carrinho.getItemCarrinhoList().get(i).setQuantidade(this.carrinho.getItemCarrinhoList().get(i).getQuantidade() - 1);
                } else {
                    this.carrinho.getItemCarrinhoList().remove(i);
                }
            }
        }
        carrinho.calcularValorTotal();
    }
    
    

}
