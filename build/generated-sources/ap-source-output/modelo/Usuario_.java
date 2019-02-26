package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Avaliacao;
import modelo.Venda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> fone;
    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, String> uf;
    public static volatile SingularAttribute<Usuario, String> cidade;
    public static volatile SingularAttribute<Usuario, String> endereco;
    public static volatile ListAttribute<Usuario, Venda> vendaList;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile ListAttribute<Usuario, Avaliacao> avaliacaoList;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, String> cep;

}