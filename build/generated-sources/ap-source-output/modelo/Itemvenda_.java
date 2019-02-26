package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Livro;
import modelo.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Itemvenda.class)
public class Itemvenda_ { 

    public static volatile SingularAttribute<Itemvenda, Venda> venda;
    public static volatile SingularAttribute<Itemvenda, Livro> livro;
    public static volatile SingularAttribute<Itemvenda, BigDecimal> valorunitario;
    public static volatile SingularAttribute<Itemvenda, Integer> id;
    public static volatile SingularAttribute<Itemvenda, Short> quantidade;

}