<%-- 
    Document   : header
    Created on : 17/11/2017, 09:32:41
    Author     : JP
--%>

<%@page import="modelo.Carrinho"%>
<%@page import="modelo.Classificacao"%>
<%@page import="dao.ClassificacaoDAO"%>
<%@page import="modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="dao.CategoriaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <script src="js/menu_jquery.js"></script>

    </head>
    <body>
        <div class="header_bg">
            <div class="container">
                <div class="header">
                    <div class="head-t">
                        <div class="logo">
                            <a href="SiteCtl?pagina=index"><img src="images/logo.png" class="img-responsive" alt=""/> </a>
                        </div>
                        <!-- start header_right -->
                        <div class="header_right">
                            <div class="rgt-bottom">
                                <c:if test="${usuario == null}">
                                    <div class="log">
                                        <div class="login" >
                                            <div id="loginContainer"><a href="#" id="loginButton"><span>Login</span></a>
                                                <div id="loginBox">                
                                                    <form id="loginForm" action="../admin/usuario/UsuarioCtl" method="POST">
                                                        <input type="hidden" value="login" name="op" />
                                                        <fieldset id="body">
                                                            <fieldset>
                                                                <label for="email">Email</label>
                                                                <input type="text" name="email" id="email">
                                                            </fieldset>
                                                            <fieldset>
                                                                <label for="senha">Senha</label>
                                                                <input type="password" name="senha" id="password">
                                                            </fieldset>
                                                            <input type="submit" id="login" value="Entrar">

                                                        </fieldset>

                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                                <div class="reg">
                                    <c:choose>
                                        <c:when test="${usuario == null}"><a href="register.jsp">REGISTRAR</a></c:when>
                                        <c:when test="${usuario != null}"><a href="SiteCtl?pagina=perfil">${usuario.getNome()}</a> <a href="../admin/usuario/UsuarioCtl?acao=sair">SAIR</a></c:when>
                                    </c:choose>
                                </div>
                                <div class="cart box_1">
                                    <a href="SiteCtl?pagina=checkout">

                                        <h3> <span class="simpleCart_total">R$<c:out value="${sessionScope.carrinho.getTotal()}" default="0.0" /></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"><c:out value="${carrinho.quantidadeLivros()}" default="0" /></span> itens)<img src="images/bag.png" alt=""></h3>

                                    </a>	

                                    <div class="clearfix"> </div>
                                </div>
                                <div class="create_btn">
                                    <a href="SiteCtl?pagina=checkout">CHECKOUT</a>
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="search">
                                <form action="SiteCtl" method="GET">
                                    <input type="hidden" name="pagina" value="lista"/>
                                    <input type="hidden" name="filtro" value="pesquisar"/>
                                    <input type="text" value="" name="pesquisa" placeholder="procurar...">
                                    <input type="submit" value="">
                                </form>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>

                    <ul class="megamenu skyblue">
                        <li class="active grid"><a class="color1" href="SiteCtl?pagina=index">Home</a></li>

                        </li>
                        <li><a class="color4" href="#">Categorias</a>
                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <h4>Categorias</h4>
                                            <ul>
                                                <c:forEach items="${listaCategorias}" var="categoria">
                                                    <li><a href="SiteCtl?pagina=lista&filtro=categoria&id=${categoria.getId()}">${categoria.getNome()}</a></li>
                                                    </c:forEach>
                                            </ul>	
                                        </div>							
                                    </div>                                        
                                </div>
                                <div class="row">
                                    <div class="col2"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                </div>
                            </div>
                        </li>				
                        <li><a class="color5" href="#">Classificações</a>
                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <h4>Classificações</h4>
                                            <ul>
                                                <c:forEach items="${listaClassificacao}" var="classificacao">
                                                    <li><a href="SiteCtl?pagina=lista&filtro=classificacao&id=${classificacao.getId()}">${classificacao.getNome()}</a></li>
                                                    </c:forEach>
                                            </ul>	
                                        </div>							
                                    </div>                                    
                                </div>
                                <div class="row">
                                    <div class="col2"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                </div>
                            </div>
                        </li>
                        <li><a class="color6" href="#">Editoras</a>
                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <h4>Editoras</h4>
                                            <ul>
                                                <c:forEach items="${listaEditoras}" var="editora">
                                                    <li><a href="SiteCtl?pagina=lista&filtro=editora&id=${editora.getId()}">${editora.getNome()}</a></li>
                                                    </c:forEach>
                                            </ul>	
                                        </div>							
                                    </div>                                  
                                    <div class="row">
                                        <div class="col2"></div>
                                        <div class="col1"></div>
                                        <div class="col1"></div>
                                        <div class="col1"></div>
                                        <div class="col1"></div>
                                    </div>
                                </div>
                        </li>				

                        <li><a class="color7" href="#">Autores</a>
                            <div class="megapanel">
                                <div class="row">
                                    <div class="col1">
                                        <div class="h_nav">
                                            <h4>Autores</h4>
                                            <ul>
                                                <c:forEach items="${listaAutores}" var="autor">
                                                    <li><a href="SiteCtl?pagina=lista&filtro=autor&id=${autor.getId()}">${autor.getNome()}</a></li>
                                                    </c:forEach>
                                            </ul>	
                                        </div>							
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col2"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                    <div class="col1"></div>
                                </div>
                            </div>
                        </li>				


                    </ul> 

                </div>
            </div>
        </div>
    </body>
</html>
