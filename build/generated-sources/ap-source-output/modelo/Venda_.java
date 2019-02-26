package modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Itemvenda;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, BigDecimal> total;
    public static volatile SingularAttribute<Venda, Date> data;
    public static volatile SingularAttribute<Venda, Usuario> usuario;
    public static volatile SingularAttribute<Venda, Integer> id;
    public static volatile ListAttribute<Venda, Itemvenda> itemvendaList;
    public static volatile SingularAttribute<Venda, Character> status;

}