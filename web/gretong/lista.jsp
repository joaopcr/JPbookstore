<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Gretong a Ecommerce Category Flat Bootstarp Responsive Website Template | Women :: w3layouts</title>

    <body>


        <%@include file="header.jsp" %>
        <!-- content -->
        <div class="container">
            <div class="women_main">
                <!-- start sidebar -->

                <!-- start content -->
                <c:if test="${listaLivros.size() > 0}">
                    <div class="col-md-12 w_content">
                        <div class="women">
                            <a href="#"><h4>Livros - <span>${quantidade} itens</span> </h4></a>
                            <ul class="w_nav">
                                <li>Ordenar : </li>

                                <li><a href="" id="orderdesc">preço: Decrescente </a></li> |                        
                                <li><a href="" id="ordercresc">preço: Crescente </a></li> 
                                <div class="clear"></div>	
                            </ul>
                            <div class="clearfix"></div>	
                        </div>
                        <!-- grids_of_4 -->
                        <div class="row">

                            <c:forEach items="${listaLivros}" var="livro">
                                <div class="col-md-3">
                                    <div class="content_box"><a href="SiteCtl?pagina=detalhes&id=${livro.getId()}">
                                            <style>
                                                img.resize {
                                                    width:400px; /* you can use % */
                                                    height: 400px;
                                                }
                                            </style>
                                            <img src="../imagem/${livro.getImagem1()}" class="img-responsive resize" alt=""/>
                                            <br>
                                        </a>
                                        <h4 align="center"><a href="SiteCtl?pagina=detalhes&id=${livro.getId()}"> ${livro.getTitulo()}</a></h4>

                                        <div class="grid_1 simpleCart_shelfItem">

                                            <div class="item_add"><span class="item_price"><h6>R$ ${livro.getPreco()}</h6></span></div>
                                            <div class="item_add"><span class="item_price"><a href="SiteCtl?pagina=detalhes&id=${livro.getId()}">Ver Detalhes</a></span></div>
                                            <br>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>                        
                            <div class="clearfix"></div>    
                        </div>                                                    


                    </div>
                </c:if>
                <c:if test="${listaLivros.size() == 0}">
                    <div class="col-md-12">
                        <br>
                        <h1 align="center">Nada encontrado</h1>
                        <h4 align="center">Clique no botão abaixo para pesquisar livros!</h3>
                            <a class="order" href="SiteCtl?pagina=lista">Pesquisar</a>


                    </div>
                </c:if>
                <div class="clearfix"></div>
                <script>
                    var url = window.location;
                    var orderdesc = document.getElementById("orderdesc");
                    var ordercresc = document.getElementById("ordercresc");
                    orderdesc.href = url + "&orderby=desc";
                    ordercresc.href = url + "&orderby=cresc";
                </script>
                <!-- end content -->
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>