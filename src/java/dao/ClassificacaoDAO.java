/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import modelo.Classificacao;

/**
 *
 * @author Aluno
 */
public class ClassificacaoDAO extends GenericDAO<Classificacao, Integer> {

    public ClassificacaoDAO() {
        super(Classificacao.class);
    }

}
