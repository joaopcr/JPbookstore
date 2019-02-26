<%@include file="../cabecalho.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String msg = "testando";
    String classe = "alert-danger";

%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sistema
            <small>Admin</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">�rea Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Aqui vai o conte�do de apresenta��o
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <div class="panel-heading">
            Livro
        </div>
        <div class="panel-body">
            <div class="alert-<%=classe%>">
                <c:out value="${msg}"/>
            </div>
            <form action="LivroCtl" method="post" enctype="multipart/form-data">

                <div class="col-lg-6">

                    <div class="form-group">
                        <label>T�tulo</label>
                        <input class="form-control" type="text" name="txtNome" required />
                    </div>
                    <div class="form-group">
                        <label>ISBN</label>
                        <input class="form-control" type="text" name="txtISBN" required />
                    </div>
                    <div class="form-group">
                        <label>Sinopse</label>
                        <textarea class="form-control" name="txtSinopse" required ></textarea>
                    </div>
                    <div class="form-group">
                        <label>Idioma</label>
                        <input class="form-control" type="text" name="txtIdioma" required />
                    </div>
                    <div class="form-group">
                        <label>Edi��o</label>
                        <input class="form-control" type="number" name="txtEdicao" required />
                    </div>
                    <div class="form-group">
                        <label>Data pubica��o</label>
                        <input class="form-control" type="date" name="txtDataPublicacao" required />
                    </div>
                    <div class="form-group">
                        <label>P�ginas</label>
                        <input class="form-control" type="number" name="txtPaginas" required />
                    </div>
                    <div class="form-group">
                        <label>Pre�o</label>
                        <input class="form-control" type="number" name="txtPreco" required />
                    </div>
                    <div class="form-group">
                        <label>Editora</label>
                        <select class="form-control" name="selEditora" required>
                            <option value="">Selecione</option>
                            <c:forEach items="${editoraList}" var="obj">
                                <option value="<c:out value="${obj.id}"/>">
                                    <c:out value="${obj.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Categoria</label>
                        <select class="form-control" name="selCategoria" required>
                            <option value="">Selecione</option>
                            <c:forEach items="${categoriaList}" var="obj">
                                <option value="<c:out value="${obj.id}"/>">
                                    <c:out value="${obj.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Classifica��o</label>
                        <select class="form-control" name="selClassificacao" required>
                            <option value="">Selecione</option>
                            <c:forEach items="${classificacaoList}" var="obj">
                                <option value="<c:out value="${obj.id}"/>">
                                    <c:out value="${obj.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Autores</label>
                        <select class="form-control" name="selAutores" multiple required>
                            <option value="">Selecione</option>
                            <c:forEach items="${autorList}" var="obj">
                                <option value="<c:out value="${obj.id}"/>">
                                    <c:out value="${obj.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Imagem 1</label>
                        <input class="form-control" type="file" accept="image/*" name="arquivo" />
                    </div>
                    <div class="form-group">
                        <label>Imagem 2</label>
                        <input class="form-control" type="file" accept="image/*" name="arquivo1" />
                    </div>
                    <div class="form-group">
                        <label>Imagem 3</label>
                        <input class="form-control" type="file" accept="image/*" name="arquivo2" />
                    </div>
                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>

            </form>

        </div>


    </div>
</div>
<!-- /.row -->
<%@include file="../rodape.jsp" %>