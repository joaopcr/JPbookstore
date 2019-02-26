<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>
<%
String msg ="testando";
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
                <i class="fa fa-dashboard"></i>  <a href="index.jsp">Área Administrativa</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Aqui vai o conteúdo de apresentação
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

            <div class="alert <%=classe%>">
                <c:out value="${msg}"/>
            </div>
            <form action="LivroCtl" method="post" enctype="multipart/form-data">

                <div class="col-lg-6">
                    <div class="form-group">
                        <label>ID</label>
                            <input class="form-control" type="text" name="txtId" readonly value="<c:out value="${obj.id}"/>" required />
                    </div>

                    <div class="form-group">
                        <label>Título</label>
                        <input class="form-control" type="text" name="txtNome" value="<c:out value="${obj.titulo}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>ISBN</label>
                        <input class="form-control" type="text" name="txtISBN" value="<c:out value="${obj.isbn}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Sinopse</label>
                        <textarea class="form-control" name="txtSinopse" required ><c:out value="${obj.sinopse}"/></textarea>
                    </div>
                    <div class="form-group">
                        <label>Idioma</label>
                        <input class="form-control" type="text" name="txtIdioma" value="<c:out value="${obj.idioma}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Edição</label>
                        <input class="form-control" type="number" name="txtEdicao" value="<c:out value="${obj.edicao}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Data pubicação</label>
                        <input class="form-control" type="date" name="txtDataPublicacao" value="<c:out value="${obj.datapublicacao}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Páginas</label>
                        <input class="form-control" type="number" name="txtPaginas" value="<c:out value="${obj.paginas}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Preço</label>
                        <input class="form-control" type="number" name="txtPreco" value="<c:out value="${obj.preco}"/>" required />
                    </div>
                    <div class="form-group">
                        <label>Editora</label>
                        <select class="form-control" name="selEditora" required>
                            <option value="">Selecione</option>
                            <c:forEach items="${editoraList}" var="obj">
                                <option value="${obj.id}" >
                                    <c:out value="${obj.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Categoria</label>
                        <select class="form-control" name="selLivro" required>
                            <option value="">Selecione</option>
                            <c:forEach items="${categoriaList}" var="obj">
                                <option value="<c:out value="${obj.id}"/>">
                                    <c:out value="${obj.nome}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Classificação</label>
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
                        <input class="form-control" type="file" name="arquivo" />
                    </div>
                    <div class="form-group">
                        <label>Imagem 2</label>
                        <input class="form-control" type="file" name="arquivo1" />
                    </div>
                    <div class="form-group">
                        <label>Imagem 3</label>
                        <input class="form-control" type="file" name="arquivo2" />
                    </div>
                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>

            </form>

        </div>


    </div>
</div>
<!-- /.row -->
<%@include file="../rodape.jsp" %>