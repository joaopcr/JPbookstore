package modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Autor;
import modelo.Avaliacao;
import modelo.Categoria;
import modelo.Classificacao;
import modelo.Editora;
import modelo.Itemvenda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-18T08:29:45")
@StaticMetamodel(Livro.class)
public class Livro_ { 

    public static volatile SingularAttribute<Livro, String> isbn;
    public static volatile SingularAttribute<Livro, Categoria> categoria;
    public static volatile SingularAttribute<Livro, String> titulo;
    public static volatile ListAttribute<Livro, Avaliacao> avaliacaoList;
    public static volatile SingularAttribute<Livro, String> idioma;
    public static volatile SingularAttribute<Livro, String> imagem1;
    public static volatile SingularAttribute<Livro, Short> edicao;
    public static volatile ListAttribute<Livro, Itemvenda> itemvendaList;
    public static volatile SingularAttribute<Livro, Editora> editora;
    public static volatile SingularAttribute<Livro, String> sinopse;
    public static volatile SingularAttribute<Livro, BigDecimal> preco;
    public static volatile SingularAttribute<Livro, Short> paginas;
    public static volatile SingularAttribute<Livro, String> imagem3;
    public static volatile SingularAttribute<Livro, String> imagem2;
    public static volatile SingularAttribute<Livro, Classificacao> classificacao;
    public static volatile SingularAttribute<Livro, Integer> id;
    public static volatile SingularAttribute<Livro, Date> datapublicacao;
    public static volatile ListAttribute<Livro, Autor> autorList;

}