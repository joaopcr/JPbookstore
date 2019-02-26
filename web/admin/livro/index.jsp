<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Gerenciamento de Livros

        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">listagem</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> listagem de registros
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">

        <div class="panel-body">

            <a href="LivroCtl?acao=add" class="btn  btn-primary btn-sm fa fa-plus-square-o">Novo</a>

        </div>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <form action="LivroCtl" method="get">
            <input type="hidden" name="acao" value="list" />
            <div class="form-group input-group">
                <input type="text" name="filtro" class="form-control"/>
                <span class="input-group-btn"><button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button></span>
            </div>
        </form>
        <div class="panel-body">


            <div class="table-responsive">                
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Idioma</th>                            
                            <th>ISBN</th>
                            <th>Titulo</th>
                            <th>Data publicação</th>
                            <th>Páginas</th>
                            <th>Edição</th>
                            <th>Editora</th>
                            <th>Categoria</th>
                            <th>Classificação</th>
                            <th>Autores</th>
                            <th>Preço</th>
                            <th>Imagens</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="obj">

                            <tr>
                                <td><c:out value="${obj.id}" /></td>
                                <td><c:out value="${obj.idioma}" /></td>
                                
                                <td><c:out value="${obj.isbn }" /></td>
                                <td><c:out value="${obj.titulo }" /></td>
                                <td><fmt:formatDate pattern='dd-MM-yyyy' value="${obj.datapublicacao }" /></td>
                                <td><c:out value="${obj.paginas }" /></td>
                                <td><c:out value="${obj.edicao }" /></td>
                                <td><c:out value="${obj.editora.nome }" /></td>
                                <td><c:out value="${obj.categoria.nome }" /></td>
                                <td><c:out value="${obj.classificacao.nome }" /></td>
                                <td><c:forEach items="${obj.autorList}" var="autor">
                                        <c:out value="${autor.getNome()}" />
                                    </c:forEach>  </td>
                                <td><c:out value="${obj.preco}" /></td>
                                <td><img src="../../imagem/<c:out value="${obj.imagem1}" />" width="40" height="40">
                                    <img src="../../imagem/<c:out value="${obj.imagem2}" />" width="40" height="40">
                                    <img src="../../imagem/<c:out value="${obj.imagem3}" />" width="40" height="40"></td>
                                <td><a href="LivroCtl?acao=upd&id=<c:out value="${obj.id}"/>" class="btn  btn-primary btn-sm">Alterar</a>
                                    <a href="LivroCtl?acao=del&id=<c:out value="${obj.id}"/>" class="btn  btn-primary btn-sm">Excluir</a>  
                                </td>
                            </tr>  
                        </c:forEach>
                    </tbody>
                </table>

                <!-- /.table-responsive -->
            </div>

        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
</div>
<%@include file="../rodape.jsp" %>
