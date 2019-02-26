<%@page import="dao.LivroDAO"%>
<%@page import="modelo.Livro"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Livraria</title>
    </head>
    <body>       
        <!-- header -->
        <%@include file="header.jsp"%>
        <style>
            h3 .ttl {
                background-color: grey;
            }
            <c:redirect url="SiteCtl?pagina=lista"></c:redirect>
        </style>
        <div class="arriv">
            <div class="container">
                <div class="arriv-top">                    
                    <c:forEach items="${listaLivros}" var="livro">                    <div class="col-md-6 arriv-left">
                            <img src="../imagem/${livro.getImagem1()}"  class="img-responsive imagem" alt="">
                            <div class="arriv-info">
                                <h3><span class="ttl">${livro.getTitulo()}</span></h3>                                
                                <div class="crt-btn">
                                    <a href="SiteCtl?pagina=detalhes&id=${livro.getId()}">VEJA</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="clearfix"> </div>
                </div>
              
            </div>
        </div>
        <br>
        <%@include file="footer.jsp"%>
    </body>
</html>