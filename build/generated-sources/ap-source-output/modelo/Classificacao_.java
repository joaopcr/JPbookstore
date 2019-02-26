package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Livro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Classificacao.class)
public class Classificacao_ { 

    public static volatile ListAttribute<Classificacao, Livro> livroList;
    public static volatile SingularAttribute<Classificacao, String> nome;
    public static volatile SingularAttribute<Classificacao, Integer> id;

}