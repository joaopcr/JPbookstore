/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import modelo.Autor;
import modelo.Livro;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class LivroDAO extends GenericDAO<Livro, Integer> {

    public LivroDAO() {
        super(Livro.class);
    }

    public List<Livro> buscarPor(String filtro, int id) {

        if (filtro.equals("autor")) {
            Query query = em.createNamedQuery("Livro.findAll");
            List<Livro> listaLivros = query.getResultList();
            List<Livro> listaReturn = new ArrayList();
            for (Livro livro : listaLivros) {
                for (Autor autor : livro.getAutorList()) {
                    if(autor.getId().equals(id))
                    listaReturn.add(livro);
                }
            }
            return listaReturn;
        } else {
            Query query = em.createNamedQuery("Livro.".concat(filtro));
            query.setParameter(filtro, id);
            return query.getResultList();
        }
    }

    public List<Livro> buscarPor(String filtro, String palavra) {
        Query query = em.createNamedQuery("Livro.".concat(filtro));
        query.setParameter(filtro, palavra);
        return query.getResultList();
    }

}
