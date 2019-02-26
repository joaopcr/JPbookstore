package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Livro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Editora.class)
public class Editora_ { 

    public static volatile ListAttribute<Editora, Livro> livroList;
    public static volatile SingularAttribute<Editora, String> logo;
    public static volatile SingularAttribute<Editora, String> nome;
    public static volatile SingularAttribute<Editora, Integer> id;

}