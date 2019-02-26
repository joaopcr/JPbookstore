<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Livro"%>
<%@page import="modelo.Carrinho"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>Gretong a Ecommerce Category Flat Bootstarp Responsive Website Template | Home :: w3layouts</title>

    </head>
    <body>
        <!-- header_top -->
        <%@include file="header.jsp" %>  

        <div class="container">
            <c:if test="${carrinho.getItemCarrinhoList().size() > 0}">
                <div class="check">	 
                    <div class="col-md-3 cart-total">

                        <div class="price-details">
                            <h3>TOTAL</h3>
                            ${sessionScope.carrinho.getTotal()}

                            <div class="clearfix"></div>				 
                        </div>	
                        <ul class="total_price">

                            <li class="last_price"><span></span></li>
                            <div class="clearfix"> </div>
                        </ul>


                        <c:choose>
                            <c:when test="${sessionScope.usuario != null}"><a class="order" href="SiteCtl?pagina=venda">Concluir Compra</a></c:when>

                            <c:when test="${sessionScope.usuario == null}"><a class="order" href="register.jsp">Fazer Login</a></c:when>                         
                        </c:choose>
                        <div class="clearfix"></div>    

                    </div>
                    <div class="col-md-9 cart-items">

                        <h5>Endereço</h5>
                        ${sessionScope.usuario.endereco}
                        <div class="clearfix"></div>
                        <h1>Meu Carrinho</h1>

                        <c:forEach items="${carrinho.getItemCarrinhoList()}" var="livro">
                            <div class="cart-header">

                                <div class="cart-sec simpleCart_shelfItem">
                                    <div class="cart-item cyc">
                                        <img src="../imagem/${livro.livro.getImagem1()}" class="img-responsive" alt=""/>
                                    </div>

                                    <div class="cart-item-info">

                                        <h3><a href="SiteCtl?pagina=detalhes&id=${livro.livro.getId()}">${livro.livro.getTitulo()}</a><span>Quantidade: <input id="input${livro.livro.getId()}" type="number" value="${livro.getQuantidade()}" min="1"></span></h3>
                                        <form action="CarrinhoCtl?id=${livro.livro.getId()}" id="comprarForm${livro.livro.getId()}" method="POST"></form>
                                        <form action="CarrinhoCtl?acao=del&id=${livro.livro.getId()}" id="exlcuirForm${livro.livro.getId()}" method="GET"></form>
                                        <script>
                                            $(document).ready(function () {
                                                var input = $("#input${livro.livro.getId()}");
                                                var valor = input.val();


                                                input.bind('mouseup', function () {
                                                    if (input.val() > 0) {
                                                        if (input.val() > valor) {
                                                            $("#comprarForm${livro.livro.getId()}").submit();
                                                            
                                                        } else if ((input.val() < valor)) {
                                                            window.location.replace("CarrinhoCtl?acao=del&id=${livro.livro.getId()}");
                                                        }
                                                    }

                                                })
                                            });
                                        </script>
                                    </div>
                                    <a href="CarrinhoCtl?acao=del&id=${livro.livro.getId()}">Excluir</a>
                                    <div class="clearfix"></div>

                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <c:if test="${carrinho.getItemCarrinhoList().size() == 0}">
                <div class="col-md-12">
                    <br>
                    <h1 align="center">Carrinho vazio</h1>
                    <h4 align="center">Clique no botão abaixo para pesquisar livros!</h3>
                        <a class="order" href="SiteCtl?pagina=lista">Pesquisar</a>


                </div>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>