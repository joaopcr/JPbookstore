/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP
 */
public class Carrinho {
    
    private List<Itemcarrinho> itemCarrinhoList;    
    private float total;

    public Carrinho() {
        this.itemCarrinhoList = new ArrayList<>();
        this.total = 0;
    }

    public void removerLivros() {

        this.itemCarrinhoList.clear();
        calcularValorTotal();
    }

    public List<Itemcarrinho> getItemCarrinhoList() {
        return itemCarrinhoList;
    }

    public void setItemCarrinhoList(List<Itemcarrinho> itemCarrinhoList) {
        this.itemCarrinhoList = itemCarrinhoList;
    }   

    public void calcularValorTotal() {
        total = 0;
        for (int i = 0; i < itemCarrinhoList.size(); i++) {
            total += itemCarrinhoList.get(i).getLivro().getPreco().floatValue() * itemCarrinhoList.get(i).getQuantidade();
        }
    }
    
    public int quantidadeLivros(){
        int cont = 0;
        for(int i = 0; i < itemCarrinhoList.size(); i++){
            cont += itemCarrinhoList.get(i).getQuantidade();
        } 
        
        return cont;
    }

    public float getTotal() {
        calcularValorTotal();
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    public void limparCarrinho(){
        itemCarrinhoList.clear();
    }

}
