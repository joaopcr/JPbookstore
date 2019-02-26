package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Livro;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Avaliacao.class)
public class Avaliacao_ { 

    public static volatile SingularAttribute<Avaliacao, Date> data;
    public static volatile SingularAttribute<Avaliacao, Livro> livro;
    public static volatile SingularAttribute<Avaliacao, Usuario> usuario;
    public static volatile SingularAttribute<Avaliacao, Integer> id;
    public static volatile SingularAttribute<Avaliacao, String> comentario;
    public static volatile SingularAttribute<Avaliacao, Short> nota;

}