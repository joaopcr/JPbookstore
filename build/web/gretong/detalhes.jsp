<%@page import="modelo.Livro"%>
<%@page import="dao.LivroDAO"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Gretong a Ecommerce Category Flat Bootstarp Responsive Website Template | Details :: w3layouts</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary JavaScript plugins) -->
        <script type='text/javascript' src="js/jquery-1.11.1.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <!-- Custom Theme files -->
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Gretong Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,900' rel='stylesheet' type='text/css'>
        <!-- start menu -->
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/etalage.css">
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <script src="js/jquery.etalage.min.js"></script>
        <script src="js/menu_jquery.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 300,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>

    </head>
    <body>
        <!-- header_top -->

        <%@include file="header.jsp" %>
        <!-- content -->
        <div class="container">
            <div class="women_main">               
                <!-- start content -->
                <div class="row single">
                    <div class="col-md-9 det">
                        <div class="single_left">
                            <div class="grid images_3_of_2">
                                <ul id="etalage">
                                    <li>
                                        <a href="optionallink.html">
                                            <img class="etalage_thumb_image" src="../imagem/${livro.getImagem1()}" class="img-responsive" />
                                            <img class="etalage_source_image" src="../imagem/${livro.getImagem1()}" class="img-responsive" title="" />
                                        </a>
                                    </li>
                                    <li>
                                        <img class="etalage_thumb_image" src="../imagem/${livro.getImagem2()}" class="img-responsive" />
                                        <img class="etalage_source_image" src="../imagem/${livro.getImagem2()}" class="img-responsive" title="" />
                                    </li>
                                    <li>
                                        <img class="etalage_thumb_image" src="../imagem/${livro.getImagem3()}" class="img-responsive"  />
                                        <img class="etalage_source_image" src="../imagem/${livro.getImagem3()}" class="img-responsive"  />
                                    </li>

                                </ul>
                                <div class="clearfix"></div>		
                            </div>
                            <div class="desc1 span_3_of_2">
                                <h3>${livro.getTitulo()}</h3>

                                <br>
                                <span class="code">Código: ${livro.getId()}</span>
                                <p>${livro.getSinopse()}</p>
                                <br>
                                <div class="price">
                                    <span class="text">Preço: </span>
                                    <span class="price-new">R$ ${livro.getPreco()}</span>

                                </div>
                                <div class="btn_form">
                                    <form action="CarrinhoCtl?id=${livro.getId()}" id="comprarForm" method="POST">
                                        <a onclick="document.getElementById('comprarForm').submit()" >Comprar</a>
                                    </form>
                                </div>



                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="single-bottom1">
                            <h6>Detalhes</h6>
                            <p class="prod-desc">Páginas: ${livro.getPaginas()}<br>ISBN: ${livro.getIsbn()}<br>Idioma: ${livro.getIdioma()}<br>Editora: <a href="SiteCtl?pagina=lista&filtro=editora&id=${livro.getEditora().getId()}">${livro.getEditora().getNome()}</a>
                                <br>Autores: <c:forEach items="${livro.getAutorList()}" var="autor"><a href="SiteCtl?pagina=lista&filtro=autor&id=${autor.getId()}">${autor.getNome()}</a>, </c:forEach>
                                </p>
                            </div>

                        </div>	
                        <div class="col-md-3">
                            <div class="w_sidebar">
                                <div class="w_nav1">
                                    <h4>Todas</h4>
                                    <ul>
                                    <c:forEach items="${listaCategorias}" var="categoria">
                                        <li><a href="SiteCtl?pagina=lista&filtro=categoria&id=${categoria.getId()}">${categoria.getNome()}</a></li>
                                        </c:forEach>
                                </ul>	
                            </div>
                            <h3>Filtrar por</h3>                                                                                   

                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="single-bottom1">
                        <h6>Avaliações</h6>
                        <c:forEach items="${listaAvaliacao}" var="avaliacao">
                            <c:choose>
                                <c:when test="${avaliacao.getNota() <= 3}"><div class="panel panel-danger"></c:when>
                                    <c:when test="${avaliacao.getNota() > 3 && avaliacao.getNota() < 7}"><div class="panel panel-default"></c:when>
                                        <c:when test="${avaliacao.getNota() >= 7}"><div class="panel panel-success"></c:when>
                                        </c:choose>

                                        <div class="panel-heading"><h5>Nota: </h5>${avaliacao.getNota()}</div>
                                        <div class="panel-body">
                                            <h5>Usuário: </h5>${avaliacao.getUsuario().getNome()}
                                            <br>
                                            <br>
                                            <h5>Data: </h5><fmt:formatDate pattern='dd/MM/yyyy' value="${avaliacao.getData()}"/>
                                            <br>
                                            <br>
                                            <h5>Comentário: </h5>${avaliacao.getComentario()}
                                        </div>
                                    </div>
                                </c:forEach>
                                <c:if test="${listaAvaliacao.isEmpty()}">
                                    Nenhuma avaliação encontrada!
                                </c:if>
                            </div>
                            <div class="clearfix"></div>
                            <c:if test="${podeComentar}">
                                <div class="single-bottom1">
                                    <h6>Avaliar</h6>
                                    <form action="AvaliacaoCtl" method="POST">
                                        <input type="hidden" name="id" value="${livro.getId()}">
                                        <div class="form-group">
                                            <label for="selectNota">Nota: </label>
                                            <select class="form-control" name="nota" id="selectNota">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>                                    
                                            </select>                                
                                        </div>
                                        <div class="form-group">
                                            <label for="comentario">Comentário</label>
                                            <textarea class="form-control" name="comentario" id="comentario"></textarea>
                                        </div>                            
                                        <button type="submit" class="btn btn-primary">Enviar</button>
                                    </form>
                                </div>
                            </c:if>
                        </div>
                        <!-- end content -->
                    </div>
                </div>

                <%@include file="footer.jsp" %>
            </div>
        </div>
    </body>
</html>
