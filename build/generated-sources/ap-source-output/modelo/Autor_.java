package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Livro;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Autor.class)
public class Autor_ { 

    public static volatile SingularAttribute<Autor, Date> datanasc;
    public static volatile SingularAttribute<Autor, String> foto;
    public static volatile ListAttribute<Autor, Livro> livroList;
    public static volatile SingularAttribute<Autor, String> nome;
    public static volatile SingularAttribute<Autor, Integer> id;
    public static volatile SingularAttribute<Autor, String> nacionalidade;
    public static volatile SingularAttribute<Autor, String> descricao;

}