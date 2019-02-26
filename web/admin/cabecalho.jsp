<%@page import="modelo.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>T�tulo do Meu projeto</title>

        <!-- Bootstrap Core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <c:if test="${sessionScope.usuario == null|| sessionScope.isAdmin == false}">
            <c:redirect url = "../../gretong/SiteCtl?pagina=index"/>
        </c:if>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="../inicial">
                        �rea Administrativa
                    </a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">

                    <li class="dropdown">

                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <c:if test="${usuario != null}">${usuario.getNome()}</c:if> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                                </li>
                                <li class="divider"></li>
                                <c:choose>
                                    <c:when test="${usuario != null}">
                                    <li>
                                        <a href="../usuario/UsuarioCtl?acao=sair"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                                    </li>
                                </c:when>
                                <c:when test="${usuario == null}">
                                    <li>
                                        <a href="../../gretong/register.jsp"><i class="fa fa-fw fa-power-off"></i> Login</a>
                                    </li>
                                </c:when>
                            </c:choose>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="../categoria/CategoriaCtl?acao=list"><i class="fa fa-fw fa-edit"></i> Categoria</a>
                        </li>
                        <li>
                            <a href="../classificacao/ClassificacaoCtl?acao=list"><i class="fa fa-fw fa-edit"></i> Classificacao</a>
                        </li>
                        <li>
                            <a href="../usuario/UsuarioCtl?acao=list"><i class="fa fa-fw fa-edit"></i>Usu�rio</a>
                        </li>
                        <li>
                            <a href="../editora/EditoraCtl?acao=list"><i class="fa fa-fw fa-edit"></i>Editora</a>
                        </li>
                        <li>
                            <a href="../autor/AutorCtl?acao=list"><i class="fa fa-fw fa-edit"></i>Autor</a>
                        </li>
                        <li>
                            <a href="../livro/LivroCtl?acao=list"><i class="fa fa-fw fa-edit"></i>Livro</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->

