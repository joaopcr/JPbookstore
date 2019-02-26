<%@include file="../cabecalho.jsp" %>
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
            Usuario
        </div>
        <div class="panel-body">
            <div class="alert <%=classe%>">
                <c:out value="${msg}"/>
            </div>
            <form action="UsuarioCtl" method="POST">
                <input type="hidden" value="add" name="op" />
                <div class="col-lg-6">
                    <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="email" name="email" required />
                    </div>
                    <div class="form-group">
                        <label>Senha</label>
                        <input class="form-control" type="password" name="senha" required />
                    </div>
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" type="text" name="nome" required />
                    </div>
                    <div class="form-group">
                        <label>CEP</label>
                        <input class="form-control" type="text" name="cep" required />
                    </div>
                    <div class="form-group">
                        <label>Endereço</label>
                        <input class="form-control" type="text" name="endereco" required />
                    </div><div class="form-group">
                        <label>CPF</label>
                        <input class="form-control" type="text" name="cpf" required />
                    </div>
                    <div class="form-group">
                        <label>Cidade</label>
                        <input class="form-control" type="text" name="cidade" required />
                    </div>
                    <div class="form-group">
                        <label>UF</label>
                        <input class="form-control" type="text" name="uf" required />
                    </div>
                    <div class="form-group">
                        <label>Fone</label>
                        <input class="form-control" type="text" name="fone" required />
                    </div>

                    <button class="btn btn-primary btn-sm" type="submit">Salvar</button>
                </div>
            </form>




        </div>
    </div>
    <!-- /.row -->
    <%@include file="../rodape.jsp" %>